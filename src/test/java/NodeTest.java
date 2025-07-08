import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    @Test
    public void CreateNode(){
        Node node = new Node("root");
        assertEquals("root",node.getName());
    }

    @Test
    public void CreateChildren(){
        Node root = new Node("root");
        Node child = new Node("child");
        root.addChildren(child);
        assertEquals(1,root.getChildrens().size());
        assertEquals("root",root.getChildrens().get(0).getName());
    }

    @Test
    public void FindChildren(){
        Node root = new Node("root");
        Node child = new Node("child");
        root.addChildren(child);
        assertTrue(root.findChildren("child"));
    }

    @Test
    public void DeleteChildren(){
        Node root = new Node("root");
        Node child = new Node("child");
        root.addChildren(child);
        assertTrue(root.findChildren("child"));
        root.deleteChildren("child");
        assertFalse(root.findChildren("child"));
    }


}
