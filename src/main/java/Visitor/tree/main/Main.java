package Visitor.tree.main;

import Visitor.tree.contrat.ITreeVisitor;
import Visitor.tree.modele.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main (String [] args){
        Composant Tree = new Node(10);
        Tree.addNode(new Node(5));
        Tree.addNode(new Node(15));
        List<Composant> children = new ArrayList<>(Tree.getChildren());
        children.get(0).addNode(new Leaf(2));
        children.get(0).addNode(new Leaf(4));
        children.get(1).addNode(new Leaf(11));
        children.get(1).addNode(new Leaf(17));

        ITreeVisitor visitorP = new VisitorTreeProfondeur();
        ITreeVisitor visitorL = new VisitorTreeLargeur();

        System.out.println("PARCOURS EN PROFONDEUR : ");
        Composant profondeur = visitorP.visitTree(Tree, new ArrayList<>(Tree.getChildren()), 10);
        if (profondeur == null) {
            System.out.println("Composant non trouvé");
        } else {
            System.out.println("LE COMPOSANT EST UN NOEUD ? " + profondeur.isNode() + " SA VALEUR EST " + profondeur.getValue());
        }

        System.out.println("PARCOURS EN LARGEUR : ");
        Composant largeur = visitorL.visitTree(Tree, new ArrayList<>(Tree.getChildren()), 15);
        if(largeur == null){
            System.out.println("Composant non trouvé");
        } else {
            System.out.println("LE COMPOSANT EST UN NOEUD ? " + largeur.isNode() + " SA VALEUR EST " + largeur.getValue());
        }
    }
}