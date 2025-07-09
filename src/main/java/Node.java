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

    public int findChildren(String name) {
        List<Node> temp = this.childrens;
        for (int i = 0; i < temp.size(); i++) {
            if (Objects.equals(name, temp.get(i).getName())){
                return i;
            }
        }
        return -1;
    }

    public void deleteChildren(String name) {
        if(this.findChildren(name) != -1){
            this.childrens.remove(this.findChildren(name));
        }

    }

    public void deleteAllChildrens() {
        if(!this.childrens.isEmpty()){
            int size_temp = this.childrens.size();
            for(int i = 0; i<size_temp; i++){
                this.childrens.remove(0);
            }
        }
    }

    public void editNode(String name) {
        this.name = name;
    }

    public int getID() {
        return this.id;
    }
}
