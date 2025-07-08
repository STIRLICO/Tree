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
        assertEquals("child",root.getChildrens().get(0).getName());
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

    @Test
    public void DeleteAllChildrens(){
        Node root = new Node("root");
        Node child1 = new Node("child1");
        Node child2 = new Node("child2");
        root.addChildren(child1);
        root.addChildren(child2);
        assertEquals(2,root.getChildrens().size());
        root.deleteAllChildrens();
        assertEquals(0,root.getChildrens().size());
    }

    @Test
    public void EditNode(){
        Node node = new Node("root");
        node.editNode("not_root");
        assertEquals("not_root",node.getName());
    }

}
