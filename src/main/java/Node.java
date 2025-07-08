import jdk.internal.org.objectweb.asm.tree.InsnList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    String id;
    String name;
    List<Node> childrens = new ArrayList<Node>();

    public Node(String name) {
        this.id = "template";
        this.name = name;
    }

    public void addChildren(Node child) {
        this.childrens.add(child);
    }

    public List<Node> getChildrens() {
        return this.childrens;
    }

    public String getName() {
        return this.name;
    }

    public int findChildren(String name) {
        List<Node> temp = this.childrens;
        for (int i = 0; i < temp.size(); i++) {
            if (Objects.equals(name, temp.get(i).getName())){return i;}
        }
        return -1;
    }

    public void deleteChildren(String name) {

    }

    public void deleteAllChildrens() {
    }

    public void editNode(String notRoot) {
    }
}
