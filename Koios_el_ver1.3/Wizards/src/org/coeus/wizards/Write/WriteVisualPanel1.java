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


package org.coeus.wizards.Write;


import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ColorUIResource;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.BalloonTip.AttachLocation;
import net.java.balloontip.BalloonTip.Orientation;
import net.java.balloontip.styles.BalloonTipStyle;
import net.java.balloontip.styles.RoundedBalloonStyle;
import org.coeus.wizards.WizardsDefinitions;
import org.coeus.wizards._HelpFuntions.addWriteCharPanel;
import org.coeus.wizards._HelpFuntions.addWriteConditionPanel;
import org.coeus.wizards._HelpFuntions.addWriteExpressionPanel;
import org.coeus.wizards._HelpFuntions.addWriteStringPanel;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

public final class WriteVisualPanel1 extends JPanel {
    private String objScope;

   // private LinkedList <String> messages= new LinkedList();
    private LinkedList <String> dispNames= new LinkedList<String>();
    private LinkedList <String> objNames= new LinkedList<String>();
    private LinkedList <String> dispTypes= new LinkedList<String>();
    private LinkedList <String> objTypes= new LinkedList<String>();
    private LinkedList <String> dispCategory= new LinkedList<String>();

    private static final int stringListSize=35;
    private int selection=-1;
    private DefaultListModel listModel = null;

     

    /** Creates new form ReadVisualPanel1 */
    public WriteVisualPanel1(String iObjScope) {
        initComponents();
        
        //customize tool tip apperance
//        UIManager.put("ToolTip.background", new ColorUIResource(255, 247, 200)); // The color is #fff7c8.
        UIManager.put("ToolTip.background", new ColorUIResource(220, 220, 220)); // The color is #fff7c8.
        Border border = BorderFactory.createLineBorder(new Color(76,79,83)); // The color is #4c4f53.
        UIManager.put("ToolTip.border", border);
        ToolTipManager.sharedInstance().setInitialDelay(0);
        ToolTipManager.sharedInstance().setDismissDelay(20000);// 20 seconds
        //end customize tool tip apperance
        
//           selectMessageBut.setToolTipText("<html><center>" + "This is a" + "<br><b>" + "tool tip" + "<font color=\"#800080\" " +
//            "size=\"4\" face=\"Verdana\">tool tip verdana" +  "</font></b></center></html>");
 selectMessageBut.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
           "Πατήστε το κουμπί \"" + "<b>Εισαγωγή Συμβολοσειράς</b>"+ "\" για να εμφανίσετε στην<br>οθόνη μηνύματα προς το χρήστη ή τιμές μεταβλητών τύπου ΣΥΜΒΟΛΟΣΕΙΡΑΣ"+"</font></html>");

 selectExpressionBut.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
         "Πατήστε το κουμπί \"" + "<b>Εισαγωγή Αριθμητικής Έκφρασής</b>"+ "\" για να εμφανίσετε στην οθόνη τιμές<br>ΑΚΕΡΑΙΩΝ ή ΠΡΑΓΜΑΤΙΚΩΝ μεταβλητών ή το αποτέλεσμα της δική σας ΑΡΙΘΜΗΤΙΚΗΣ ΕΚΦΡΑΣΗΣ"+"</font></html>");

         

 selectCharacterBut.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
         "Πατήστε το κουμπί \"" + "<b>Εισαγωγή Χαρακτήρα</b>"+ "\" για να εμφανίσετε στην<br>οθόνη έναν χαρακτήρα ή τιμές μεταβλητών τύπου ΧΑΡΑΚΤΗΡΑ"+"</font></html>");

 selectConditionBut.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
         "Πατήστε το κουμπί \"" + "<b>Εισαγωγή Λογικής Συνθήκης</b>"+ "\" για να εμφανίσετε στην οθόνη<br>τιμές ΛΟΓΙΚΩΝ μεταβλητών ή το αποτέλεσμα της δικής σας ΛΟΓΙΚΗΣ ΣΥΝΘΗΚΗΣ"+"</font></html>");


        this.objScope=iObjScope;
        setEditDeleteButtonsEnabled(false);
        setUpDownButtonsEnabled(false);

        listModel = new DefaultListModel();
        jList1.setModel(listModel);

        jList1.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int sel;
                sel=jList1.getSelectedIndex();
                if (sel>-1)
                {
                  selection=sel;
                  checkUpDownButtons();
                  setEditDeleteButtonsEnabled(true);
                }
            }
        });

    jList1.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                checkUpDownButtons(); }
            public void focusLost(FocusEvent e) {
              //  setUpDownButtonsEnabled(false);
            }
        });
 //new printLists(messages,dispNames,objNames,dispTypes,objTypes,dispCategory);

            jList1.addMouseListener(new MouseListener () {

            public void mouseClicked(MouseEvent e) {
               if (selection>-1)
                  if(e.getClickCount() == 2)
                       editElement();
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }

        });



    }

    @Override
    public String getName() {
        return "ΓΡΑΨΕ : Καθορισμός Παραμέτρων";
    }

     private void setEditDeleteButtonsEnabled(boolean tf)
    {
      EditBut.setEnabled(tf);
      DeleteSelectedBut.setEnabled(tf);
      DeleteAllBut.setEnabled(tf);
    }

   
    private void setUpDownButtonsEnabled(boolean tf)
    {
     UpBut.setEnabled(tf);
     DownBut.setEnabled(tf);
    }


  ///GETTERS
//    public LinkedList<String> getMessages()
//    {return this.messages;}

    public LinkedList<String> getDispArguements()
    {return this.dispNames;}

     public LinkedList<String> getObjArguements()
    {return this.objNames;}

     public LinkedList<String> getDispArguementsType()
    {return this.dispTypes;}

     public LinkedList<String> getObjArguementsType()
    {return this.objTypes;}

    public LinkedList<String> getDispCategory()
    {return this.dispCategory;}

     /////SETTERS
//    public void setMessages(LinkedList<String> iMessages)
//    {this.messages=iMessages;}

    public void setDispArguements(LinkedList<String> iDispNames)
    {this.dispNames=iDispNames;}

     public void setObjArguements(LinkedList<String> iObjNames)
    {this.objNames=iObjNames;}

     public void setDispArguementsType(LinkedList<String> iDispTypes)
    {this.dispTypes=iDispTypes;}

     public void setObjArguementsType(LinkedList<String> iObjTypes)
    {this.objTypes=iObjTypes;}

    public void setDispCategory(LinkedList<String> iDispCategory)
    {this.dispCategory=iDispCategory;}


     public String strings2ListModelItem(String name,String category,String type)
     { String result="",nname,ncategory,ntype;

       if (name.length()>stringListSize)
           nname=name.substring(0,stringListSize);
       else
         nname = padWithSpaceChars(name);

       ncategory=padWithSpaceChars(category);
       ntype=padWithSpaceChars(type);

   

     result=nname+ncategory+ntype;
     return result;
     }

    private String padWithSpaceChars (String inString)
    {String temp="",outString="";
    int difference = stringListSize- inString.length();
    for (int i=0;i<difference;i++)
        temp=temp+" ";
    outString=inString+temp;
    return outString;
    }



    public void addExpression()
    {
     addWriteExpressionPanel aEP = new addWriteExpressionPanel(this.objScope,null);
     aEP.getParametersButton().setVisible(true);
//     aEP.getHeaders()[0].setVisible(false);
//     aEP.getHeaders()[1].setVisible(false);
//     aEP.getHeaders()[2].setVisible(false);
//     aEP.getHeaders()[3].setVisible(false);

      NotifyDescriptor d =new NotifyDescriptor.Confirmation(aEP,aEP.getName(),
      NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);

      if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
      {
        if (aEP.checkValidExpression(NotifyDescriptor.OK_CANCEL_OPTION))
         {
           dispNames.add(aEP.getDisplayExpression());
           objNames.add("("+aEP.getObjectExpresssion()+")");
           dispTypes.add(WizardsDefinitions.EXPRESSION);
           objTypes.add("EXPRSSION");
           dispCategory.add(WizardsDefinitions.EXPRESSION);

       listModel.addElement(strings2ListModelItem(aEP.getDisplayExpression(),WizardsDefinitions.EXPRESSION,""));
        }
      }
    }

    public void updateExpression()
    {
  addWriteExpressionPanel aEP = new addWriteExpressionPanel(this.objScope,dispNames.get(selection));
     aEP.getParametersButton().setVisible(true);
//     aEP.getHeaders()[0].setVisible(false);
//     aEP.getHeaders()[1].setVisible(false);
//     aEP.getHeaders()[2].setVisible(false);
//     aEP.getHeaders()[3].setVisible(false);

      NotifyDescriptor d =new NotifyDescriptor.Confirmation(aEP,aEP.getName(),
      NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);

      if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
      {
        if (aEP.checkValidExpression(NotifyDescriptor.OK_CANCEL_OPTION))
         {
           dispNames.remove(selection);
           objNames.remove(selection);
           dispTypes.remove(selection);
           objTypes.remove(selection);
           dispCategory.remove(selection);            
            
           dispNames.add(selection,aEP.getDisplayExpression());
           objNames.add(selection,"("+aEP.getObjectExpresssion()+")");
           dispTypes.add(selection,WizardsDefinitions.EXPRESSION);
           objTypes.add(selection,"EXPRSSION");
           dispCategory.add(selection,WizardsDefinitions.EXPRESSION);

       listModel.remove(selection);
       listModel.insertElementAt(strings2ListModelItem(aEP.getDisplayExpression(),WizardsDefinitions.EXPRESSION,""),selection);
        }
      }


    }

    public void addCharacter()
    {
      addWriteCharPanel aEP = new addWriteCharPanel(this.objScope,null);
     aEP.getParametersButton().setVisible(true);
//     aEP.getHeaders()[0].setVisible(false);
//     aEP.getHeaders()[1].setVisible(false);
//     aEP.getHeaders()[2].setVisible(false);
//     aEP.getHeaders()[3].setVisible(false);

      NotifyDescriptor d =new NotifyDescriptor.Confirmation(aEP,aEP.getName(),
      NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);

//      if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
//      {
//        if (aEP.checkValidInput(NotifyDescriptor.OK_CANCEL_OPTION))
//         {
//           dispNames.add(aEP.getDisplayChar());
//           objNames.add(aEP.getObjChar());
//           dispTypes.add(WizardsDefinitions.CHARACTER);
//           objTypes.add("CHARACTER");
//           dispCategory.add(WizardsDefinitions.CHARACTER);
//
//         listModel.addElement(strings2ListModelItem(aEP.getDisplayChar(),WizardsDefinitions.CHARACTER,""));
//        }
//      }
//
//    }

  if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
   {
           if (aEP.checkValidInput(NotifyDescriptor.OK_CANCEL_OPTION))
           {

               ///////////////////////////////////
              if (aEP.getCharTextField().isVisible())
               {
                   aEP.putCharInLabel();
                   d =new NotifyDescriptor.Confirmation(aEP,aEP.getName(),
                   NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);

                    if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
                         {
                             if (aEP.checkValidInput(NotifyDescriptor.OK_CANCEL_OPTION))
                                       {
                                       dispNames.add(aEP.getDisplayChar());
                                       objNames.add(aEP.getObjChar());
                                       dispTypes.add(WizardsDefinitions.CHARACTER);
                                       objTypes.add("CHARACTER");
                                       dispCategory.add(WizardsDefinitions.CHARACTER);

                                       listModel.addElement(strings2ListModelItem(aEP.getDisplayChar(),WizardsDefinitions.CHARACTER,""));
                                       }
                         }
                    }
                    else
                    {
               ////////////////////////////////////
                       dispNames.add(aEP.getDisplayChar());
                       objNames.add(aEP.getObjChar());
                       dispTypes.add(WizardsDefinitions.CHARACTER);
                       objTypes.add("CHARACTER");
                       dispCategory.add(WizardsDefinitions.CHARACTER);

                       listModel.addElement(strings2ListModelItem(aEP.getDisplayChar(),WizardsDefinitions.CHARACTER,""));
                     }
             }
       }
 }


//    public void updateCharacter()
//    {
//          addWriteCharPanel aEP = new addWriteCharPanel(this.objScope,dispNames.get(selection));
//     aEP.getParametersButton().setVisible(true);
////     aEP.getHeaders()[0].setVisible(false);
////     aEP.getHeaders()[1].setVisible(false);
////     aEP.getHeaders()[2].setVisible(false);
////     aEP.getHeaders()[3].setVisible(false);
//
//      NotifyDescriptor d =new NotifyDescriptor.Confirmation(aEP,aEP.getName(),
//      NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);
//
//      if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
//      {
//        if (aEP.checkValidInput(NotifyDescriptor.OK_CANCEL_OPTION)  && !aEP.getObjNames().isEmpty())
//         {
//           dispNames.remove(selection);
//           objNames.remove(selection);
//           dispTypes.remove(selection);
//           objTypes.remove(selection);
//           dispCategory.remove(selection);
//
//           dispNames.add(selection,aEP.getDisplayChar());
//           objNames.add(selection,aEP.getObjChar());
//           dispTypes.add(selection,WizardsDefinitions.CHARACTER);
//           objTypes.add(selection,"CHARACTER");
//           dispCategory.add(WizardsDefinitions.CHARACTER);
//
//       listModel.remove(selection);
//       listModel.insertElementAt(strings2ListModelItem(aEP.getDisplayChar(),WizardsDefinitions.CHARACTER,""),selection);
//        }
//      }
//    }

public void updateCharacter()
{
     addWriteCharPanel aEP = new addWriteCharPanel(this.objScope,dispNames.get(selection));

    NotifyDescriptor d =new NotifyDescriptor.Confirmation(aEP,aEP.getName(),
      NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);

 aEP.getObjArguements().add(objNames.get(selection));

      if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
   {
           if (aEP.checkValidInput(NotifyDescriptor.OK_CANCEL_OPTION))
           {

               ///////////////////////////////////
              if (aEP.getCharTextField().isVisible())
               {
                   aEP.putCharInLabel();
                   d =new NotifyDescriptor.Confirmation(aEP,aEP.getName(),
                   NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);

                    if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
                         {
                             if (aEP.checkValidInput(NotifyDescriptor.OK_CANCEL_OPTION))
                                {
                                   dispNames.remove(selection);
                                   objNames.remove(selection);
                                   dispTypes.remove(selection);
                                   objTypes.remove(selection);
                                   dispCategory.remove(selection);

                                   dispNames.add(selection,aEP.getDisplayChar());
                                   objNames.add(selection,aEP.getObjChar());
                                   dispTypes.add(selection,WizardsDefinitions.CHARACTER);
                                   objTypes.add(selection,"CHARACTER");
                                   dispCategory.add(WizardsDefinitions.CHARACTER);

                                   listModel.remove(selection);
                                   listModel.insertElementAt(strings2ListModelItem(aEP.getDisplayChar(),WizardsDefinitions.CHARACTER,""),selection);
                              }
                         }
                    }
                    else
                    {
               ////////////////////////////////////

                   dispNames.remove(selection);
                   objNames.remove(selection);
                   dispTypes.remove(selection);
                   objTypes.remove(selection);
                   dispCategory.remove(selection);

                   dispNames.add(selection,aEP.getDisplayChar());
                   objNames.add(selection,aEP.getObjChar());
                   dispTypes.add(selection,WizardsDefinitions.CHARACTER);
                   objTypes.add(selection,"CHARACTER");
                   dispCategory.add(WizardsDefinitions.CHARACTER);

                   listModel.remove(selection);
                   listModel.insertElementAt(strings2ListModelItem(aEP.getDisplayChar(),WizardsDefinitions.CHARACTER,""),selection);
                   }
            }
      }
}



    public void addCondition()
    {
      addWriteConditionPanel aCP = new addWriteConditionPanel(this.objScope,null);
      aCP.getParametersButton().setVisible(true);
//      aCP.getHeaders()[0].setVisible(false);
//      aCP.getHeaders()[1].setVisible(false);
//      aCP.getHeaders()[2].setVisible(false);
//      aCP.getHeaders()[3].setVisible(false);

      NotifyDescriptor d =new NotifyDescriptor.Confirmation(aCP,aCP.getName(),
      NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);

  if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
   {
         if (aCP.checkValidCondition(NotifyDescriptor.OK_CANCEL_OPTION))
           {

           dispNames.add(aCP.getDisplayCondition());
           objNames.add("("+aCP.getObjectCondition()+")");
           dispTypes.add(WizardsDefinitions.CONDITION);
           objTypes.add("CONDITION");
           dispCategory.add(WizardsDefinitions.CONDITION);

       listModel.addElement(strings2ListModelItem(aCP.getDisplayCondition(),WizardsDefinitions.CONDITION,""));

           }       
   }
 }

    public void updateCondition()
    {
      addWriteConditionPanel aCP = new addWriteConditionPanel(this.objScope,dispNames.get(selection));
      aCP.getParametersButton().setVisible(true);
//      aCP.getHeaders()[0].setVisible(false);
//      aCP.getHeaders()[1].setVisible(false);
//      aCP.getHeaders()[2].setVisible(false);
//      aCP.getHeaders()[3].setVisible(false);

      NotifyDescriptor d =new NotifyDescriptor.Confirmation(aCP,aCP.getName(),
      NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);

   if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
   {     
      if (aCP.checkValidCondition(NotifyDescriptor.OK_CANCEL_OPTION))
           {
           dispNames.remove(selection);
           objNames.remove(selection);
           dispTypes.remove(selection);
           objTypes.remove(selection);
           dispCategory.remove(selection);

           dispNames.add(aCP.getDisplayCondition());
           objNames.add("("+aCP.getObjectCondition()+")");
           dispTypes.add(WizardsDefinitions.CONDITION);
           objTypes.add("CONDITION");
           dispCategory.add(WizardsDefinitions.CONDITION);

       listModel.remove(selection);
       listModel.insertElementAt(strings2ListModelItem(aCP.getDisplayCondition(),WizardsDefinitions.CONDITION,""),selection);

           }
       
   }
 }



public void addString()
{

     addWriteStringPanel gSP = new addWriteStringPanel(this.objScope,null);

     NotifyDescriptor d =new NotifyDescriptor.Confirmation(gSP,gSP.getName(),
             NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);
     
  
      if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
      {
         if (gSP.checkValidInput(NotifyDescriptor.OK_CANCEL_OPTION))
         {
         dispNames.add(gSP.getDisplayString());
         objNames.add(gSP.getObjString());
         dispTypes.add(WizardsDefinitions.MESSAGE);
      // objTypes.add("MESSAGE");
         objTypes.add("STRING");
         dispCategory.add(WizardsDefinitions.MESSAGE);

         listModel.addElement(strings2ListModelItem(gSP.getDisplayString(),WizardsDefinitions.MESSAGE,""));
      }
}
     


}
 

//public void updateString()
//{
//     addWriteStringPanel gWP = new addWriteStringPanel(this.objScope,dispNames.get(selection));
////     gWP.getHeaders()[0].setVisible(false);
////     gWP.getHeaders()[1].setVisible(false);
////     gWP.getHeaders()[2].setVisible(false);
////     gWP.getHeaders()[3].setVisible(false);
//
//     NotifyDescriptor d =new NotifyDescriptor.Confirmation(gWP,gWP.getName(),
//      NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);
//
//   if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
//   {
//       if(gWP.getDisplayString()!=null)
//       {
//           if (!gWP.getDisplayString().equalsIgnoreCase(""))
//           {
//
//           dispNames.remove(selection);
//           objNames.remove(selection);
//           dispTypes.remove(selection);
//           objTypes.remove(selection);
//           dispCategory.remove(selection);
//
//
//           dispNames.add(selection,gWP.getDisplayString());
//           objNames.add(selection,gWP.getObjString());
//           dispTypes.add(selection,WizardsDefinitions.MESSAGE);
////           objTypes.add(selection,"MESSAGE");
//           objTypes.add(selection,"STRING");
//           dispCategory.add(selection,WizardsDefinitions.MESSAGE);
//
//       listModel.remove(selection);
//       listModel.insertElementAt(strings2ListModelItem(gWP.getDisplayString(),WizardsDefinitions.MESSAGE,""),selection);
//
//           }
//       }
//   }
//}




public void updateString()
{
     addWriteStringPanel gWP = new addWriteStringPanel(this.objScope,dispNames.get(selection));

     NotifyDescriptor d =new NotifyDescriptor.Confirmation(gWP,gWP.getName(),
      NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);


     gWP.getObjArguements().add(objNames.get(selection));

      if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
   {
           if (gWP.checkValidInput(NotifyDescriptor.OK_CANCEL_OPTION))
           {

               ///////////////////////////////////
              if (gWP.getStringTextField().isVisible())
               {
                   gWP.putStringInLabel();
                   d =new NotifyDescriptor.Confirmation(gWP,gWP.getName(),
                   NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);

                    if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
                         {
                             if (gWP.checkValidInput(NotifyDescriptor.OK_CANCEL_OPTION))
                                {
                                   dispNames.remove(selection);
                                   objNames.remove(selection);
                                   dispTypes.remove(selection);
                                   objTypes.remove(selection);
                                   dispCategory.remove(selection);


                                   dispNames.add(selection,gWP.getDisplayString());
                                   objNames.add(selection,gWP.getObjString());
                                   dispTypes.add(selection,WizardsDefinitions.MESSAGE);
                        //           objTypes.add(selection,"MESSAGE");
                                   objTypes.add(selection,"STRING");
                                   dispCategory.add(selection,WizardsDefinitions.MESSAGE);

                                   listModel.remove(selection);
                                   listModel.insertElementAt(strings2ListModelItem(gWP.getDisplayString(),WizardsDefinitions.MESSAGE,""),selection);
                              }
                         }
                    }
                    else
                    {
               ////////////////////////////////////

           dispNames.remove(selection);
           objNames.remove(selection);
           dispTypes.remove(selection);
           objTypes.remove(selection);
           dispCategory.remove(selection);


           dispNames.add(selection,gWP.getDisplayString());
           objNames.add(selection,gWP.getObjString());
           dispTypes.add(selection,WizardsDefinitions.MESSAGE);
//           objTypes.add(selection,"MESSAGE");
           objTypes.add(selection,"STRING");
           dispCategory.add(selection,WizardsDefinitions.MESSAGE);

       listModel.remove(selection);
       listModel.insertElementAt(strings2ListModelItem(gWP.getDisplayString(),WizardsDefinitions.MESSAGE,""),selection);

           }
        }
    }
}








private void editElement()
{
 if (selection>-1)
 {
  if (dispCategory.get(selection).equalsIgnoreCase(WizardsDefinitions.CONDITION))
          updateCondition();
  else if (dispCategory.get(selection).equalsIgnoreCase(WizardsDefinitions.MESSAGE))
          updateString();
  else if (dispCategory.get(selection).equalsIgnoreCase(WizardsDefinitions.EXPRESSION))
          updateExpression();
  else if (dispCategory.get(selection).equalsIgnoreCase(WizardsDefinitions.CHARACTER))
          updateCharacter();
  jList1.setSelectedIndex(selection);
 }
}


 private void checkUpDownButtons()
    {
       setUpDownButtonsEnabled(true);

       if (selection>-1)
       {
         if (selection==0)
               UpBut.setEnabled(false);
         if (selection==listModel.getSize()-1)
               DownBut.setEnabled(false);
       }
       else
           setUpDownButtonsEnabled(false);

       if (listModel.size()==1)   setUpDownButtonsEnabled(false);
    }

private void oneElementUp()
{String s2,s3,s4,s5,s6;
    if (selection>0)
    {
     int selected=selection;
     String  object= (String)listModel.getElementAt(selected);
     listModel.remove(selected);
     listModel.insertElementAt(object,selected-1);
     jList1.setSelectedIndex(selected-1);

        
          s2= dispNames.get(selected);
          s3= objNames.get(selected);
          s4= dispTypes.get(selected);
          s5= objTypes.get(selected);
          s6= dispCategory.get(selected);

       
           dispNames.remove(selected);
           objNames.remove(selected);
           dispTypes.remove(selected);
           objTypes.remove(selected);
           dispCategory.remove(selected);


       
           dispNames.add(selected-1, s2);
           objNames.add(selected-1, s3);
           dispTypes.add(selected-1, s4);
           objTypes.add(selected-1, s5);
           dispCategory.add(selected-1, s6);
    }
}


private void oneElementDown()
{String s2,s3,s4,s5,s6;
    if (selection>-1 && selection<listModel.getSize()-1)
    {
     int selected=selection;
     String  object= (String)listModel.getElementAt(selected);
     listModel.remove(selected);
     listModel.insertElementAt(object,selected+1);
     jList1.setSelectedIndex(selected+1);
    
          s2= dispNames.get(selected);
          s3= objNames.get(selected);
          s4= dispTypes.get(selected);
          s5= objTypes.get(selected);
          s6= dispCategory.get(selected);
       
           dispNames.remove(selected);
           objNames.remove(selected);
           dispTypes.remove(selected);
           objTypes.remove(selected);
           dispCategory.remove(selected);

           dispNames.add(selected+1, s2);
           objNames.add(selected+1, s3);
           dispTypes.add(selected+1, s4);
           objTypes.add(selected+1, s5);
           dispCategory.add(selected+1, s6);
    }
}


private void clearAll()
{

     NotifyDescriptor d =new NotifyDescriptor.Confirmation(
                "Πρόκειται να διαγράψετε όλα τα στοιχεία που έχετε επιλέξει!\n" +
                "Είστε σίγουροι οτι θέλετε να συνεχίσετε;",
                "Επιβεβαίωση Διαγραφής ",
     NotifyDescriptor.YES_NO_OPTION,NotifyDescriptor.WARNING_MESSAGE);

         if (DialogDisplayer.getDefault().notify(d) == NotifyDescriptor.YES_OPTION) {

           dispNames.clear();
           objNames.clear();
           dispTypes.clear();
           objTypes.clear();
           dispCategory.clear();

           listModel.clear();

           setEditDeleteButtonsEnabled(false);
           setUpDownButtonsEnabled(false);
           selection=-1;
     }
}


public void clearOne()
{
   if (selection>-1)
         {
           dispNames.remove(selection);
           objNames.remove(selection);
           dispTypes.remove(selection);
           objTypes.remove(selection);
           dispCategory.remove(selection);

           listModel.remove(selection);

          if (selection==0 && !listModel.isEmpty())
          {}
          else if (selection<=listModel.size() )
             selection=selection-1;
          jList1.setSelectedIndex(selection);

          if (listModel.isEmpty())
          {
           setEditDeleteButtonsEnabled(false);
           setUpDownButtonsEnabled(false);
          }
      }

}

    public DefaultListModel getListModel()
    {return this.listModel;}


   private void createDirectionsPopupWindow()
   {
       

       String balloonText="<html><div align=\"justify\"><font color=\"#000000\"size=\"4\" face=\"Tahoma\">" +
                                "Η εντολή ΓΡΑΨΕ εμφανίζει πληροφορίες στην οθόνη. Επιλέξτε το είδος της<br>" +
                                " πληροφορίας που θέλετε να εμφανίσετε στην οθόνη πατώντας ένα από τα<br>" +
                                "κουμπιά <b>«Εισαγωγή Συμβολοσειράς»</b>,<b>«Εισαγωγή Αριθμητικής Έκφρασης»</b>,<br>" +
                                "<b>«Εισαγωγή χαρακτήρα»</b> και <b>«Εισαγωγή Λογικής Συνθήκης»</b>.<br>" +
                                "Πηγαίνοντας το ποντίκι πάνω από το αντίστοιχο κουμπί ενημερώνεστε για<br>" +
                                "τη λειτουργία του. Κάθε φορά που πατάτε ένα από τα παραπάνω κουμπιά το<br>" +
                                "αντίστοιχο στοιχειό προστίθεται στην λίστα προς εκτύπωση.Όσα στοιχεία <br>" +
                                "υπάρχουν στη λίστα τόσες τιμές θα εμφανίσει στην οθόνη η εντολή ΓΡΑΨΕ.<br>" +
                                "Τα στοιχειά που υπάρχουν στην λίστα μπορούν να αλλάξουν σειρά εκτύπωσης<br>" +
                                "με τα κουμπιά <b>«Επάνω»</b> και <b>«Κάτω»</b>(<i>το στοιχείο στην κορυφή της λίστας<br>" +
                                "εκτυπώνεται πρώτο κ.ο.κ</i>) και να τροποποιηθούν ή να διαγραφούν<br>" +
                                "με τα κουμπιά <b>«Επεξεργασία Επιλεγμένου Στοιχείου»</b>,<b>«Διαγραφή<br>" +
                                "Επιλεγμένου Στοιχείου»</b> και <b>«Διαγραφή Όλων των Στοιχείων»</b>.</font></div></html>";
       
       BalloonTipStyle edgedLook = new RoundedBalloonStyle(10,10,Color.WHITE, Color.BLUE);
       
     new BalloonTip(this.directionsButton,balloonText,edgedLook,Orientation.RIGHT_ABOVE,AttachLocation.SOUTHWEST,40,20,true  );

   }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectMessageBut = new javax.swing.JButton();
        selectConditionBut = new javax.swing.JButton();
        selectExpressionBut = new javax.swing.JButton();
        selectCharacterBut = new javax.swing.JButton();
        directionsButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        UpBut = new javax.swing.JButton();
        DownBut = new javax.swing.JButton();
        DeleteAllBut = new javax.swing.JButton();
        DeleteSelectedBut = new javax.swing.JButton();
        EditBut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        org.openide.awt.Mnemonics.setLocalizedText(selectMessageBut, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.selectMessageBut.text")); // NOI18N
        selectMessageBut.setPreferredSize(new java.awt.Dimension(155, 25));
        selectMessageBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectMessageButActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(selectConditionBut, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.selectConditionBut.text")); // NOI18N
        selectConditionBut.setPreferredSize(new java.awt.Dimension(155, 25));
        selectConditionBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectConditionButActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(selectExpressionBut, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.selectExpressionBut.text")); // NOI18N
        selectExpressionBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectExpressionButActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(selectCharacterBut, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.selectCharacterBut.text")); // NOI18N
        selectCharacterBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCharacterButActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(directionsButton, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.directionsButton.text")); // NOI18N
        directionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directionsButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.jPanel1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.jLabel12.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel13, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.jLabel13.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel14, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.jLabel14.text")); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel16, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.jLabel16.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(UpBut, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.UpBut.text")); // NOI18N
        UpBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpButActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(DownBut, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.DownBut.text")); // NOI18N
        DownBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownButActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(DeleteAllBut, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.DeleteAllBut.text")); // NOI18N
        DeleteAllBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAllButActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(DeleteSelectedBut, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.DeleteSelectedBut.text")); // NOI18N
        DeleteSelectedBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteSelectedButActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(EditBut, org.openide.util.NbBundle.getMessage(WriteVisualPanel1.class, "WriteVisualPanel1.EditBut.text")); // NOI18N
        EditBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel16)
                    .addComponent(UpBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DownBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(EditBut)
                .addGap(18, 18, 18)
                .addComponent(DeleteSelectedBut)
                .addGap(18, 18, 18)
                .addComponent(DeleteAllBut))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(23, 23, 23)
                        .addComponent(UpBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DownBut)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditBut)
                    .addComponent(DeleteSelectedBut)
                    .addComponent(DeleteAllBut))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectCharacterBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectMessageBut, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectConditionBut, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(selectExpressionBut, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                        .addGap(138, 138, 138)
                        .addComponent(directionsButton))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectMessageBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectExpressionBut, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectCharacterBut)
                            .addComponent(selectConditionBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(directionsButton))
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EditButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButActionPerformed
        editElement();
}//GEN-LAST:event_EditButActionPerformed

    private void DeleteSelectedButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteSelectedButActionPerformed
        clearOne();
}//GEN-LAST:event_DeleteSelectedButActionPerformed

    private void DeleteAllButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAllButActionPerformed
        clearAll();
}//GEN-LAST:event_DeleteAllButActionPerformed

    private void DownButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownButActionPerformed
        oneElementDown();
}//GEN-LAST:event_DownButActionPerformed

    private void UpButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpButActionPerformed
        oneElementUp();
}//GEN-LAST:event_UpButActionPerformed

    private void selectMessageButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectMessageButActionPerformed
        addString();
}//GEN-LAST:event_selectMessageButActionPerformed

    private void selectConditionButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectConditionButActionPerformed
        addCondition();
}//GEN-LAST:event_selectConditionButActionPerformed

    private void selectExpressionButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectExpressionButActionPerformed
       addExpression();
    }//GEN-LAST:event_selectExpressionButActionPerformed

    private void selectCharacterButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCharacterButActionPerformed
        addCharacter();
    }//GEN-LAST:event_selectCharacterButActionPerformed

    private void directionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directionsButtonActionPerformed
       createDirectionsPopupWindow();
    }//GEN-LAST:event_directionsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteAllBut;
    private javax.swing.JButton DeleteSelectedBut;
    private javax.swing.JButton DownBut;
    private javax.swing.JButton EditBut;
    private javax.swing.JButton UpBut;
    private javax.swing.JButton directionsButton;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton selectCharacterBut;
    private javax.swing.JButton selectConditionBut;
    private javax.swing.JButton selectExpressionBut;
    private javax.swing.JButton selectMessageBut;
    // End of variables declaration//GEN-END:variables
}

