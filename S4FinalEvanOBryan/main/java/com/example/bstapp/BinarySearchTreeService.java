@Service
class BinarySearchTreeService {

    public TreeNode constructBST(List<Integer> numbers) {
        TreeNode root = null;
        for (int num : numbers) {
            root = insertIntoBST(root, num);
        }
        return root;
    }

    private TreeNode insertIntoBST(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.value) {
            root.left = insertIntoBST(root.left, value);
        } else {
            root.right = insertIntoBST(root.right, value);
        }
        return root;
    }

    public String serializeTree(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return "{" +
                "\"value\":" + root.value + "," +
                "\"left\":" + serializeTree(root.left) + "," +
                "\"right\":" + serializeTree(root.right) +
                "}";
    }
}
