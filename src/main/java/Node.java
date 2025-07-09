import jdk.internal.org.objectweb.asm.tree.InsnList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    int id;
    String name;
    List<Node> childrens = new ArrayList<Node>();

    public Node(String name) {
        this.id = 0;
        this.name = name;
    }

    public void addChildren(Node child) {
        this.childrens.add(child);
        this.childrens.get(this.childrens.size()-1).id = this.childrens.size();
    }

    public List<Node> getChildrens() {
        return this.childrens;
    }

    public String getName() {
        return this.name;
    }

    public Node findChildren(String name) {
        List<Node> temp = this.childrens;
        for (Node node : temp) {
            if (Objects.equals(name, node.getName())) {
                return node;
            }
        }
        return null;
    }

    public void deleteChildren(String name) {
        if(this.findChildren(name) != null){
            this.childrens.remove(this.findChildren(name));
        }

    }

    public void deleteAllChildrens() {
        if(!this.childrens.isEmpty()){
            int size_temp = this.childrens.size();
            this.childrens.subList(0, size_temp).clear();
        }
    }

    public void editNode(String name) {
        this.name = name;
    }

    public int getID() {
        return this.id;
    }

    public Node findDescendant(String name) {
        List<Node> temp1 = this.childrens;
        for (Node node : temp1) {
            if (Objects.equals(name, node.getName())) {
                return node;
            }
        }
        for (Node node : temp1) {
            if (node.findDescendant(name) != null) {
                return node.findDescendant(name);
            }
        }
        return null;
    }
}
