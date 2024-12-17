import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeServiceTest {

    private final BinarySearchTreeService service = new BinarySearchTreeService();

    @Test
    void testConstructBST() {
        TreeNode root = service.constructBST(List.of(5, 3, 7, 2, 4));
        assertNotNull(root);
        assertEquals(5, root.value);
        assertEquals(3, root.left.value);
        assertEquals(7, root.right.value);
    }

    @Test
    void testSerializeTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        String json = service.serializeTree(root);
        assertEquals("{\"value\":5,\"left\":{\"value\":3,\"left\":null,\"right\":null},\"right\":{\"value\":7,\"left\":null,\"right\":null}}", json);
    }

    @Test
    void testEmptyTreeSerialization() {
        String json = service.serializeTree(null);
        assertEquals("null", json);
    }
}