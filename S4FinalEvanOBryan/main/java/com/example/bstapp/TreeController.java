@Controller
@RequestMapping("/")
class TreeController {
    @Autowired
    private BinarySearchTreeService treeService;

    @Autowired
    private TreeRepository treeRepository;

    @GetMapping("enter-numbers")
    public String showInputPage() {
        return "input";
    }

    @PostMapping("process-numbers")
    @ResponseBody
    public Map<String, Object> processNumbers(@RequestParam String numbers) {
        List<Integer> numberList = Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        TreeNode bstRoot = treeService.constructBST(numberList);
        String treeJson = treeService.serializeTree(bstRoot);

        // Save to database
        TreeEntity treeEntity = new TreeEntity(numbers, treeJson);
        treeRepository.save(treeEntity);

        Map<String, Object> response = new HashMap<>();
        response.put("inputNumbers", numberList);
        response.put("tree", treeJson);
        return response;
    }

    @GetMapping("previous-trees")
    public String showPreviousTrees(Model model) {
        List<TreeEntity> trees = treeRepository.findAll();
        model.addAttribute("trees", trees);
        return "previous-trees";
    }
}