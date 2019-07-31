/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author HEMANT KUMAR
 */
class Bnode {
    int data;
    Bnode left;
    Bnode right;
}
    
public class BST {
    public Bnode createNewNode(int k){
        Bnode a = new Bnode();
        a.data=k;
        a.left=a.right=null;
        return a;
    }
    public Bnode insert(Bnode node,int val){
        if(node==null){
            return createNewNode(val);
        }
        if(val<node.data){
            node.left=insert(node.left,val); }
        else if(val>node.data){
                    node.right = insert(node.right,val);
                    }   
        return node;
}
    public Bnode delete(Bnode node, int val){
        if(node==null){
            return null;
        }
        else if(val<node.data){
            node.left = delete(node.left,val);
        }
        else if(val>node.data){
            node.right= delete(node.right,val);
        }
        else{
            if(node.left==null||node.right==null){
               Bnode temp=null;
               temp= node.left==null ? node.right : node.left;
               if(temp==null){
                   return null;
               }else return temp;
            }else{
                Bnode successor = getSuccessor(node);
                node.data = successor.data;
                node.right = delete(node.right,successor.data);
                return node;
            }
        }
        return node;
    }
    public Bnode getSuccessor(Bnode node){
        if(node == null){
            return null;
        }
        Bnode temp = node.right;
        while(temp.left!=null){
            temp = temp.left;
        }
        return temp;
    }
    public void inOrder(Bnode node){
        if(node==null) return;
        inOrder(node.left);
        System.out.print(node.data +" ");
        inOrder(node.right);
    }
    public void preOrder(Bnode node){
        if(node==null ) return;
        System.out.print(node.data+" ");
        
        preOrder(node.left);
        preOrder(node.right);
    }
    public void postOrder(Bnode node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
        
    }
    public boolean search(Bnode node, int val){
        if(node==null) return false;
        while(node!=null){
            if(val<node.data)
                node = node.left;
            else if(val>node.data)
                node = node.right;
            else return true;
        }
        return false;
        
    }
    
    public Bnode getParent(Bnode node, int val){
        if(node==null) return null;
        Bnode getparent=null;
        while(node!=null){
            if(val<node.data){
                getparent=node;
                node = node.left; }
            else if(val>node.data){
                getparent=node;
                node = node.right; }
            else break;
        }
        return node!=null ? getparent : null;
    }
    public Bnode getSiblings(Bnode node, int val){
        if(node==null) return null;
        Bnode getparent=null;
        while(node!=null){
            if(val<node.data){
                getparent=node.right;
                node = node.left; }
            else if(val>node.data){
                getparent=node.left;
                node = node.right; }
            else break;
        }
        return node!=null ? getparent : null;
    }
    
    public Bnode getInorderParent(Bnode node, int val){
        if(node==null) return null;
        Bnode inorderparent=null;
        while(node!=null){
            if(val<node.data){
                inorderparent=node;
                node = node.left; }
            else if(val>node.data){
                
                node = node.right; }
            else break;
        }
        return node!=null ? inorderparent : null;
    }
    
    
    public Bnode getInorderSuccessor(Bnode node, int val){
        if(node==null) return null;
        Bnode inordersuccessor=null;
        while(node!=null){
            if(val<node.data){
                inordersuccessor=node;
                node = node.left; }
            else if(val>node.data){                
                node = node.right; }
            else { if(node.right!=null){
                inordersuccessor=getsuccessor(node);
            } break;
            }
            }
        return node!=null ? inordersuccessor : null;
    }

    public Bnode getsuccessor(Bnode node) {
       if(node==null)  return null;
       Bnode temp= node.right;
       while(temp.left!=null){
           temp=temp.left;
       }
       return temp;
    }
    public int getDifferenceEvenOddLevel(Bnode node){
        if(node==null) return 0;
        return node.data-getDifferenceEvenOddLevel(node.left)-getDifferenceEvenOddLevel(node.right);
    }
    
    public int getMaxElement(Bnode node){
        if(node==null) return 0;
        while(node.right!=null){
            node=node.right;
        }
        return node.data;
    }
}
