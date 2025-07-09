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
        assertEquals(1, root.getChildrens().get(0).getID());
    }

    @Test
    public void FindChildren(){
        Node root = new Node("root");
        Node child = new Node("child");
        root.addChildren(child);
        assertEquals(child,root.findChildren("child"));
    }

    @Test
    public void FindDescendant(){
        Node root = new Node("root");
        Node child1 = new Node("child1");
        Node child2 = new Node("child2");
        root.addChildren(child1);
        root.addChildren(child2);
        Node child3 = new Node("child3");
        Node child4 = new Node("child4");
        root.childrens.get(1).addChildren(child3);
        root.childrens.get(1).childrens.get(0).addChildren(child4);
        assertEquals(child4 ,root.findDescendant("child4"));
    }

    @Test
    public void DeleteChildren(){
        Node root = new Node("root");
        Node child = new Node("child");
        root.addChildren(child);
        assertEquals(child,root.findChildren("child"));
        root.deleteChildren("child");
        assertNull(root.findChildren("child"));
    }

    @Test
    public void DeleteAllChildrens(){
        Node root = new Node("root");
        Node child1 = new Node("child1");
        Node child2 = new Node("child2");
        Node child3 = new Node("child3");
        root.addChildren(child1);
        root.addChildren(child2);
        root.addChildren(child3);
        assertEquals(3,root.getChildrens().size());
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
