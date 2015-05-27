/*
 *Copyright (c) 2009-2015, Ioannis Vasilopoulos
 *All rights reserved.
 *
 *Redistribution and use in source and binary forms, with or without
 *modification, are permitted provided that the following conditions are met:
 *    * Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *    * Neither the name of Koios nor the
 *      names of its contributors may be used to endorse or promote products
 *      derived from this software without specific prior written permission.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER BE LIABLE FOR ANY
 *DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */


package org.coeus.btvpalette;

 import java.util.ArrayList;
import org.openide.nodes.Index;
import org.openide.nodes.Node;



public class ProgCompChildren extends Index.ArrayChildren{

    private boolean advance;
    private Category category;
    private String path ="org/coeus/btvpalette/pngs/items/";

    
    private String[][] itemsAdvance = new String[][]{
        {"con", "Μεταβλητές-Σταθερές", "con1.png","Σταθερά"},
        {"var", "Μεταβλητές-Σταθερές", "var.png","Μεταβλητή"},
        {"arr", "Μεταβλητές-Σταθερές", "array.png","Πίνακας"},
        {"wri", "Εντολές Εισόδου-Εξόδου", "write.png","Γράψε"},
        {"rea", "Εντολές Εισόδου-Εξόδου", "read.png","Διάβασε"},
        {"iff", "Δομή Επιλόγής", "if_then_else.png","Εάν..Τότε..Αλλιως"},
        {"for","Δομές Επανάληψης", "for.png","Για..Από..Μέχρι"},
        {"whi","Δομές Επανάληψης", "while.png","Όσο..Επανέλαβε"},
        {"dwh","Δομές Επανάληψης", "doWhile.png","Κάνε..Όσο"},
        {"ass","Ανάθεση-Κλήση", "assign.png","Ανάθεση"},
        {"cal","Ανάθεση-Κλήση", "call.png","Κλήση"},
        {"pro","Διαδικασίες-Συναρτήσεις", "proc.png","Διαδικασία"},
        {"fun","Διαδικασίες-Συναρτήσεις", "func.png","Συνάρτηση"},
        {"ret","Διαδικασίες-Συναρτήσεις", "return.png","Επιστροφή"},
        
    };


      private String[][] itemsNovice = new String[][]{
       {"var", "Μεταβλητές-Σταθερές", "var.png","Μεταβλητή"},

        {"wri", "Εντολές Εισόδου-Εξόδου", "write.png","Γράψε"},
        {"rea", "Εντολές Εισόδου-Εξόδου", "read.png","Διάβασε"},

        {"iff", "Δομή Επιλόγής", "if_then_else.png","Εάν..Τότε..Αλλιως"},

        {"for","Δομές Επανάληψης", "for.png","Για..Από..Μέχρι"},
        
       
        {"ass","Ανάθεση-Κλήση", "assign.png","Ανάθεση"},
        {"cal","Ανάθεση-Κλήση", "call.png","Κλήση"},

        {"pro","Διαδικασίες-Συναρτήσεις", "proc.png","Διαδικασία"},


    };


    public ProgCompChildren(Category Category,boolean advance) {
        this.category = Category;
        this.advance=advance;
    }

 
    @Override
    protected java.util.List<Node> initCollection() {
        ArrayList<Node> childrenNodes = new ArrayList<Node>( itemsAdvance.length );
        if (advance)
        {
        for( int i=0; i<itemsAdvance.length; i++ ) {
            if( category.getName().equals( itemsAdvance[i][1] ) ) {
                ProgComp item =new ProgComp();
                item.setType(itemsAdvance[i][0]);
                item.setCategory(itemsAdvance[i][1]);
                item.setImage(path+itemsAdvance[i][2]);
                item.setTitle(itemsAdvance[i][3]);
                childrenNodes.add( new ProgCompNode( item ) );
            }
          }
        }
        else
        {
        for( int i=0; i<itemsNovice.length; i++ ) {
            if( category.getName().equals( itemsNovice[i][1] ) ) {
                ProgComp item =new ProgComp();
                item.setType(itemsNovice[i][0]);
                item.setCategory(itemsNovice[i][1]);
                item.setImage(path+itemsNovice[i][2]);
                item.setTitle(itemsNovice[i][3]);
                childrenNodes.add( new ProgCompNode( item ) );
            }
          }
        }
        return childrenNodes;
    }
}




