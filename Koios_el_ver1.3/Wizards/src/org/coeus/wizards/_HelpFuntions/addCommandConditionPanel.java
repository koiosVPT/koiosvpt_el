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


/*
 * addCommandConditionPanel.java
 *
 * Created on 19 Ιουν 2009, 9:06:39 μμ
 */

package org.coeus.wizards._HelpFuntions;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.BalloonTip.AttachLocation;
import net.java.balloontip.BalloonTip.Orientation;
import net.java.balloontip.styles.BalloonTipStyle;
import net.java.balloontip.styles.RoundedBalloonStyle;
import org.coeus.btvpalette.myAdvanceAction;
import org.coeus.wizards.FuncCall.FuncCallWizardAction;
import org.coeus.wizards.TextActions.AddPopupMenu;
import org.coeus.wizards.TextActions.GetFocus;
import org.coeus.wizards.WizardsDefinitions;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

public final class addCommandConditionPanel extends JPanel {
    private String objScope;

   // private LinkedList <String> messages= new LinkedList();
    private LinkedList <String> dispNames= new LinkedList<String> ();
    private LinkedList <String> objNames= new LinkedList<String> ();
    private LinkedList <String> dispTypes= new LinkedList<String> ();
    private LinkedList <String> objTypes= new LinkedList<String> ();
    private LinkedList <String> dispCategory= new LinkedList<String> ();

     private getArrayElementsList gAEL=null;
     private getParametersList gPL= null;
     private getVariablesList gVL = null;
     private getConstantsList gCL = null;
     private getFunctionsList gFL = null;

     private String objectCondition=null;
 //    private String dispTypicalParameterName=null;

     private boolean result;
     //private String commandName="";
     private String[] error =new String[2];
     private checkUsersInput check=null;
     private ActionEvent e;

     private String commandName=null;



    /** Creates new form ReadVisualPanel1 */
    public addCommandConditionPanel (String iObjScope,String condition,String iCommandName) {
        initComponents();

        ///Border styling.......
      //  BorderFactory.createLineBorder(Color.black);

        showAdvanceButtons();
        this.objScope=iObjScope;
        this.commandName=iCommandName;
        setDeleteButtonsEnabled(false);
        new AddPopupMenu(this.conditionTextField);
        this.conditionTextField.addCaretListener(new parenthesesMatcher());
         showParenthesisLabels(false);


   //customize tool tip apperance
        UIManager.put("ToolTip.background", new ColorUIResource(220, 220, 220)); // The color is #fff7c8.
        Border border = BorderFactory.createLineBorder(new Color(76,79,83)); // The color is #4c4f53.
        UIManager.put("ToolTip.border", border);
        ToolTipManager.sharedInstance().setInitialDelay(0);
        ToolTipManager.sharedInstance().setDismissDelay(20000);// 20 seconds
        //end customize tool tip apperance

        this.jPanel1.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
           "Πατήστε ένα κουμπί απο το πλαίσιο \"" + "<b>Αριθμητικοί Τελεστές</b>"+ "\" για να<br>εισάγετε στη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ τον αντίστοιχο τελεστή"+"</font></html>");
        this.jPanel4.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
           "Πατήστε ένα κουμπί απο το πλαίσιο \"" + "<b>Αριθμοί & Παρενθέσεις</b>"+ "\" για να<br>εισάγετε στη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ τον αντίστοιχο αριθμό ή παρένθεση."+"</font></html>");
        this.jPanel6.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
           "Πατήστε ένα κουμπί απο το πλαίσιο \"" + "<b>Λογικοί Τελεστέοι</b>"+ "\" για να<br>εισάγετε στη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ τον αντίστοιχο λογικό τελεστέο."+"</font></html>");
        this.jPanel7.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
           "Πατήστε ένα κουμπί απο το πλαίσιο \"" + "<b>Σχεσιακοί Τελεστέοι</b>"+ "\" για να<br>εισάγετε στη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ τον αντίστοιχο σχεσιακο τελεστέο."+"</font></html>");
        this.jPanel7.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
           "Πατήστε ένα κουμπί απο το πλαίσιο \"" + "<b>Σχεσιακοί Τελεστέοι</b>"+ "\" για να<br>εισάγετε στη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ τον αντίστοιχο σχεσιακο τελεστέο."+"</font></html>");

        this.selectVariableBut.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
           "Πατήστε το κουμπί \"" + "<b>Εισαγωγή Μεταβλητής</b>"+ "\" για να εισάγετε<br>στη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ τη μεταβλητή που θα επίλεξτε."+"</font></html>");
        this.selectArrElemBut.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
           "Πατήστε το κουμπί \"" + "<b>Εισαγωγή Στοιχείου Πίνακα</b>"+ "\" για να εισάγετε<br>στη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ το στοιχείο πίνακα που θα επίλεξτε."+"</font></html>");
        this.selectConstantBut.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
           "Πατήστε το κουμπί \"" + "<b>Εισαγωγή Σταθεράς</b>"+ "\" για να εισάγετε<br>στη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ τη σταθερά που θα επίλεξτε."+"</font></html>");
        this.selectFunctionBut.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
           "Πατήστε το κουμπί \"" + "<b>Εισαγωγή Συνάρτησης</b>"+ "\" για να εισάγετε<br>στη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ τη συνάρτηση που θα επίλεξτε."+"</font></html>");
        this.selectParameterBut.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
           "Πατήστε το κουμπί \"" + "<b>Εισαγωγή Παραμέτρου</b>"+ "\" για να εισάγετε<br>στη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ τη παράμετρο εισόδου που θα επίλεξτε."+"</font></html>");
        this.selectCharBut.setToolTipText("<html><font color=\"#003333\""+"size=\"4\" face=\"Tahoma\">"+
           "Πατήστε το κουμπί \"" + "<b>Εισαγωγή Χαρακτήρα</b>"+ "\" για να εισάγετε<br>στη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ το χαρακτήρα που θα επίλεξτε."+"</font></html>");



      getParametersList intPL=null,doublePL = null,boolPL=null;
      getArrayElementsList intAEL=null,doubleAEL=null,boolAEL=null;
      getVariablesList intVL=null,doubleVL= null,boolVL=null;
      getConstantsList intCL=null,doubleCL = null,boolCL=null;
      getFunctionsList intFL=null,doubleFL = null,boolFL=null;



        if (condition!=null)
        {
             setDeleteButtonsEnabled(true);
             conditionTextField.setText(condition);
        }

////Get integers..........
         intPL  = new getParametersList(this.objScope,WizardsDefinitions.INT);
         intAEL = new getArrayElementsList(this.objScope,WizardsDefinitions.INT);
         intVL = new getVariablesList(this.objScope,WizardsDefinitions.INT);
         intCL = new getConstantsList(this.objScope,WizardsDefinitions.INT);
         intFL = new getFunctionsList(WizardsDefinitions.INT);
////Get double...........
         doublePL  = new getParametersList(this.objScope,WizardsDefinitions.DOUBLE);
         doubleAEL = new getArrayElementsList(this.objScope,WizardsDefinitions.DOUBLE);
         doubleVL = new getVariablesList(this.objScope,WizardsDefinitions.DOUBLE);
         doubleCL = new getConstantsList(this.objScope,WizardsDefinitions.DOUBLE);
         doubleFL = new getFunctionsList(WizardsDefinitions.DOUBLE);

////Get boolean...........
         boolPL  = new getParametersList(this.objScope,WizardsDefinitions.BOOLEAN);
         boolAEL = new getArrayElementsList(this.objScope,WizardsDefinitions.BOOLEAN);
         boolVL = new getVariablesList(this.objScope,WizardsDefinitions.BOOLEAN);
         boolCL = new getConstantsList(this.objScope,WizardsDefinitions.BOOLEAN);
         boolFL = new getFunctionsList(WizardsDefinitions.BOOLEAN);


//Combine integers and doubles.................
         intPL.getDispParams().addAll(doublePL.getDispParams());
         intPL.getObjParams().addAll(doublePL.getObjParams());
         intPL.getDispParamsTypes().addAll(doublePL.getDispParamsTypes());
         intPL.getObjParamsTypes().addAll(doublePL.getObjParamsTypes());

         intAEL.getListWithArrays().addAll(doubleAEL.getListWithArrays());
         intVL.getListWithVariables().addAll(doubleVL.getListWithVariables());
         intCL.getListWithConstants().addAll(doubleCL.getListWithConstants());
         intFL.getListWithFunctions().addAll(doubleFL.getListWithFunctions());

//Combine integers, doubles and booleans.................
         intPL.getDispParams().addAll(boolPL.getDispParams());
         intPL.getObjParams().addAll(boolPL.getObjParams());
         intPL.getDispParamsTypes().addAll(boolPL.getDispParamsTypes());
         intPL.getObjParamsTypes().addAll(boolPL.getObjParamsTypes());

         intAEL.getListWithArrays().addAll(boolAEL.getListWithArrays());
         intVL.getListWithVariables().addAll(boolVL.getListWithVariables());
         intCL.getListWithConstants().addAll(boolCL.getListWithConstants());
         intFL.getListWithFunctions().addAll(boolFL.getListWithFunctions());


///////Use combined integer, doubles  and booleans.....
         gPL  = new getParametersList(this.objScope, intPL.getDispParams(), intPL.getObjParams(),
                 intPL.getDispParamsTypes(),intPL.getObjParamsTypes());

         gAEL = new getArrayElementsList(this.objScope,intAEL.getListWithArrays());
         gVL = new getVariablesList(this.objScope,intVL.getListWithVariables());
         gCL = new getConstantsList(this.objScope, intCL.getListWithConstants());
         gFL = new getFunctionsList(intFL.getListWithFunctions());


          if (gVL.getListWithVariables().isEmpty())
             selectVariableBut.setEnabled(false);

         if (gAEL.getDisplayNames()==null)
             selectArrElemBut.setEnabled(false);

         if (gPL.getDisplayNames()==null)
             selectParameterBut.setEnabled(false);

         if (gCL.getDisplayNames()==null)
             selectConstantBut.setEnabled(false);

          if (gFL.getDisplayNames()==null)
             selectFunctionBut.setEnabled(false);

 //new printLists(messages,dispNames,objNames,dispTypes,objTypes,dispCategory);

            conditionTextField.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
               switch (e.getKeyCode())
               {
//                   case KeyEvent.VK_BACK_SPACE:
//                       break;
//                   case KeyEvent.VK_DELETE:
//                       break;
                   case KeyEvent.VK_RIGHT:
                       break;
                   case KeyEvent.VK_LEFT:
                       break;
                   default: e.consume();
                        break;
               }

            }

            public void keyPressed(KeyEvent e) {

//               if (e.getKeyCode()==KeyEvent.VK_SPACE)
//                       addText(" ");
                 switch (e.getKeyCode())
               {
                   case KeyEvent.VK_RIGHT:
                       break;
                   case KeyEvent.VK_LEFT:
                       break;
                   default: e.consume();
                        break;
               }
            }

            public void keyReleased(KeyEvent e) {

            }

        });
    }

    @Override
    public String getName() {
        return "Δημιουργία ΛΟΓΙΚΗΣ ΣΥΝΘΗΚΗΣ";
    }


       private void showAdvanceButtons()
    {
     myAdvanceAction mAA = myAdvanceAction.getAdvanceAction();
     if (!mAA.getToolbarPresenter().isSelected())
       setAdvancedButtonsVisible(false);
    }


      private void setAdvancedButtonsVisible(boolean tf)
    {
      this.selectArrElemBut.setVisible(tf);
      this.selectConstantBut.setVisible(tf);
      this.selectFunctionBut.setVisible(tf);

    }




     private void setDeleteButtonsEnabled(boolean tf)
    {
      DeleteConditionBut.setEnabled(tf);
      deleteLastBut.setEnabled(tf);
    }

   public JButton getParametersButton()
   {return this.selectParameterBut;}

    public void showParenthesisLabels(boolean tf)
   {
      lParenthesisLabel.setVisible(tf);
      rParenthesisLabel.setVisible(tf);
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



       public void addConstant()
    {
      getCommandConstantsListPanel gCLP = new getCommandConstantsListPanel(gCL,this.commandName,null,null,null,null);

      NotifyDescriptor d =new NotifyDescriptor.Confirmation(gCLP,"Επιλογή Σταθεράς",
      NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);


   if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
   {
       if(gCLP.getDName()!=null)
       {
           if (!gCLP.getDName().equalsIgnoreCase(""))
           {
           dispNames.add(gCLP.getDName());
           objNames.add(gCLP.getOName());
           dispTypes.add(gCLP.getDType());
           objTypes.add(gCLP.getOType());
           dispCategory.add(WizardsDefinitions.CONSTANT);

          //conditionTextField.setText(conditionTextField.getText()+" "+gCLP.getDName());
          addTextNoSpaces(gCLP.getDName());
          setDeleteButtonsEnabled(true);
          }
       }
   }
 }


  public void addParameter()
    {
      getCommandParametersListPanel gPLPanel = new getCommandParametersListPanel(gPL,this.commandName,null,null,null,null);

      NotifyDescriptor d =new NotifyDescriptor.Confirmation(gPLPanel,"Επιλογή Παραμέτρου",
      NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);


   if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
   {
       if(gPLPanel.getDName()!=null)
       {
           if (!gPLPanel.getDName().equalsIgnoreCase(""))
           {
           dispNames.add(gPLPanel.getDName());
           objNames.add(gPLPanel.getOName());
           dispTypes.add(gPLPanel.getDType());
           objTypes.add(gPLPanel.getOType());
           dispCategory.add(WizardsDefinitions.PARAMETER);

      //conditionTextField.setText(conditionTextField.getText()+" "+gPLPanel.getDName());
      addTextNoSpaces(gPLPanel.getDName());
setDeleteButtonsEnabled(true);
           }
       }
   }
 }


//public void addOldFunction()
//{
// getCommandFunctionsListPanel gFLP = new getCommandFunctionsListPanel(gFL,null,null,null,null);
//
//       NotifyDescriptor d =new NotifyDescriptor.Confirmation(gFLP,"Επιλογή Συνάρτησης",
//       NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);
//
//
//   if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
//   {
//       if(gFLP.getDName()!=null)
//       {
//           if (!gFLP.getDName().equalsIgnoreCase(""))
//           {
//           dispNames.add(gFLP.getDName());
//           objNames.add(gFLP.getOName());
//           dispTypes.add(gFLP.getDType());
//           objTypes.add(gFLP.getOType());
//           dispCategory.add(WizardsDefinitions.FUNCTION);
//
//           conditionTextField.setText(conditionTextField.getText()+gFLP.getDName());
// setDeleteButtonsEnabled(true);
//           }
//       }
//   }
//}


public void addFunction()
{
  FuncCallWizardAction fcwa= new FuncCallWizardAction(false,this.objScope,gFL);
  fcwa.actionPerformed(e);

   if ( fcwa.getCreated())
   {
         //  if (!gFLP.getDName().equalsIgnoreCase(""))
        //   {
           dispNames.add(fcwa.getDisplayFunctionCall());
           objNames.add(fcwa.getObjectFunctionCall());
           dispTypes.add(fcwa.getDispFunctionType());
           objTypes.add(fcwa.getObjFunctionType());
           dispCategory.add(WizardsDefinitions.FUNCTION);

           //conditionTextField.setText(conditionTextField.getText()+" "+fcwa.getDisplayFunctionCall());
           addTextNoSpaces(fcwa.getDisplayFunctionCall());
           setDeleteButtonsEnabled(true);
       //    }
   }
}


public void addVariable()
{
 getCommandVariablesListPanel gVLPanel = new getCommandVariablesListPanel(gVL,this.commandName,null,null,null,null);

       NotifyDescriptor d =new NotifyDescriptor.Confirmation(gVLPanel,"Επιλογή Μεταβλητής",
       NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);


   if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
   {
       if(gVLPanel.getDName()!=null)
       {
           if (!gVLPanel.getDName().equalsIgnoreCase(""))
           {
          // messages.add(gVLPanel.getMessage());
           dispNames.add(gVLPanel.getDName());
           objNames.add(gVLPanel.getOName());
           dispTypes.add(gVLPanel.getDType());
           objTypes.add(gVLPanel.getOType());
           dispCategory.add(WizardsDefinitions.VARIABLE);

           //conditionTextField.setText(conditionTextField.getText()+" "+gVLPanel.getDName());
           addTextNoSpaces(gVLPanel.getDName());
           setDeleteButtonsEnabled(true);
           }
       }
   }
}


public void addArrayElement(String name)
{
    getCommandArrayElementsListPanel gAELPanel = new getCommandArrayElementsListPanel(gAEL,this.commandName,null,null,null,null);

       NotifyDescriptor d =new NotifyDescriptor.Confirmation(gAELPanel,"Επιλογή Στοιχείου Πίνακα",
       NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);


   if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
   {
       if(gAELPanel.getDArrayName()!=null)
       {
         if (!gAELPanel.getReturnDisplaeStateMent().equalsIgnoreCase(""))
         {
           dispNames.add(gAELPanel.getReturnDisplaeStateMent());
           objNames.add(gAELPanel.getReturnObjectStatement());
           dispTypes.add(gAELPanel.getDArrayType());
           objTypes.add(gAELPanel.getOArrayType());
           dispCategory.add(WizardsDefinitions.ARRAY_ELEMANT);

       //conditionTextField.setText(conditionTextField.getText()+" "+gAELPanel.getReturnDisplaeStateMent());
       addTextNoSpaces(gAELPanel.getReturnDisplaeStateMent());
       setDeleteButtonsEnabled(true);
       }
       }
   }
}

//public void addCharacter()
//{
//     addCommandCharPanel aEP = new addCommandCharPanel(this.objScope,null,this.commandName);
////     aEP.getHeaders()[0].setVisible(false);
////     aEP.getHeaders()[1].setVisible(false);
////     aEP.getHeaders()[2].setVisible(false);
////     aEP.getHeaders()[3].setVisible(false);
//
//
//      NotifyDescriptor d =new NotifyDescriptor.Confirmation(aEP,"Επιλογή Χαρακτήρα",
//       NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);
//
//      if ( DialogDisplayer.getDefault().notify(d)==NotifyDescriptor.OK_OPTION)
//      {
//        if (aEP.checkValidInput(NotifyDescriptor.DEFAULT_OPTION))
//         {
//           dispNames.add(aEP.getDisplayChar());
//           objNames.add(aEP.getObjChar());
//           dispTypes.add(aEP.getDType());
//           objTypes.add(aEP.getOType());
//           dispCategory.add(WizardsDefinitions.CHARACTER);
//
//
//           addText(aEP.getDisplayChar());
//           setDeleteButtonsEnabled(true);
//        }
//       }
//    }


    public void addCharacter()
    {
      addCommandCharPanel aEP = new addCommandCharPanel(this.objScope,null,this.commandName);
     aEP.getParametersButton().setVisible(true);
     aEP.getHeaders()[0].setText("Εισάγετε έναν χαρακτήρα στη συνθήκη για την εντολή");
     aEP.getHeaders()[1].setText(commandName);
     aEP.getHeaders()[2].setText("");
     aEP.getHeaders()[3].setText("");

      NotifyDescriptor d =new NotifyDescriptor.Confirmation(aEP,aEP.getName(),
      NotifyDescriptor.OK_CANCEL_OPTION,NotifyDescriptor.PLAIN_MESSAGE);

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
                                       dispTypes.add(aEP.getDType());
                                       objTypes.add(aEP.getOType());
                                       dispCategory.add(WizardsDefinitions.CHARACTER);

                                       addTextNoSpaces(aEP.getDisplayChar());
                                       setDeleteButtonsEnabled(true);                                                 
                                 }
                          }
                    }
                    else
                    {
               ////////////////////////////////////
                       dispNames.add(aEP.getDisplayChar());
                       objNames.add(aEP.getObjChar());
                       dispTypes.add(aEP.getDType());
                       objTypes.add(aEP.getOType());
                       dispCategory.add(WizardsDefinitions.CHARACTER);

                       addTextNoSpaces(aEP.getDisplayChar());
                       setDeleteButtonsEnabled(true);
                    }
                }
           }
 }



private void clearAll()
{

     NotifyDescriptor d =new NotifyDescriptor.Confirmation(
                "Πρόκειται να διαγράψετε όλη την ΣΥΝΘΗΚΗ που έχετε δημιουργήσει!\n" +
                "Είστε σίγουροι οτι θέλετε να συνεχίσετε;",
                "Επιβεβαίωση Διαγραφής ",
     NotifyDescriptor.YES_NO_OPTION,NotifyDescriptor.WARNING_MESSAGE);

         if (DialogDisplayer.getDefault().notify(d) == NotifyDescriptor.YES_OPTION)
         {
             conditionTextField.setText("");
             setDeleteButtonsEnabled(false);

         }
}

private void deleteLast()
{
    String s=conditionTextField.getText().trim();
    int lastSpacePos=s.lastIndexOf(" ");
    if (lastSpacePos>0)
       conditionTextField.setText(s.substring(0,lastSpacePos ));
    else
    {
         conditionTextField.setText("");
         setDeleteButtonsEnabled(false);
    }
}

public void addText(String text)
{
 int pos=this.conditionTextField.getCaretPosition();
 if (pos>=0 && pos <this.conditionTextField.getText().length())
 {
    String  part1=conditionTextField.getText().substring(0, pos);
    String  part2=conditionTextField.getText().substring(pos,conditionTextField.getText().length());
    this.conditionTextField.setText(part1+" "+text+" "+part2);
    this.conditionTextField.setCaretPosition(pos+text.length()+1);
 }
 else
      conditionTextField.setText(conditionTextField.getText()+" "+text+" ");
new GetFocus(this.conditionTextField);
 setDeleteButtonsEnabled(true);
}



public void addTextNoSpaces(String text)
{
 int pos=this.conditionTextField.getCaretPosition();
 if (pos>=0 && pos <this.conditionTextField.getText().length())
 {
    String  part1=conditionTextField.getText().substring(0, pos);
    String  part2=conditionTextField.getText().substring(pos,conditionTextField.getText().length());
    this.conditionTextField.setText(part1+text+part2);
    this.conditionTextField.setCaretPosition(pos+text.length()+1);
 }
 else
      conditionTextField.setText(conditionTextField.getText()+text);
new GetFocus(this.conditionTextField);
 setDeleteButtonsEnabled(true);
}


public String getDisplayCondition()
{ return conditionTextField.getText();}

public JTextField getConditionTextFiled()
{return this.conditionTextField;}

public JLabel getErrorLabel()
{return this.errorLabel;}

public JLabel [] getHeaders()
{return new JLabel [] {this.jLabel31,this.jLabel32,this.jLabel33,this.jLabel34};}

public String getObjectCondition()
{return this.objectCondition;}


private void validConditions()
{   result=true;
      if(this.conditionTextField.getText().isEmpty() || checkIdentifierForWhiteChars(this.conditionTextField.getText()))
        {
         result=false;
         error[0]="Η Έκφρασή δεν μπορέι να είναι κενή!";
         error[1]="";
        }
      else
        {
            check =new checkUsersInput(this.conditionTextField.getText(),this.objScope,true);
            result= check.checkCondition();
            error =check.getError();
         }

}



 public boolean checkValidCondition(int buttonsOptions)
    {
     validConditions();
     while(!result)
             {
              NotifyDescriptor d =new NotifyDescriptor.Confirmation(this,this.getName(),
              buttonsOptions,NotifyDescriptor.PLAIN_MESSAGE);

              this.errorLabel.setText(error[0]);
              searchNselect(this.conditionTextField,error[1]);
              new GetFocus(this.conditionTextField);

              Object answer=DialogDisplayer.getDefault().notify(d);
              
             if ( answer==NotifyDescriptor.OK_OPTION)
               validConditions();
             else if (answer==NotifyDescriptor.CLOSED_OPTION)
               result=false;// return false;
             else if ( answer==NotifyDescriptor.CANCEL_OPTION)
               return false;
          }
    this.objectCondition=check.getConditionObjStatetment();
  return true;
  }


 private void searchNselect (JTextField tf,String text)
 {
   String content = tf.getText();
   content=content.toUpperCase();
        int index = content.indexOf(text, 0);
        if (index >= 0) {   // match found
           // try {
                int end = index + text.length();
               // hilit.addHighlight(index, end, painter);
                tf.setCaretPosition(end);
                tf.setSelectionStart(index);
                tf.setSelectionEnd(end);
           // } catch (BadLocationException e) {}

        }
 }

 private boolean checkIdentifierForWhiteChars(String id)
  { return (id.trim()).isEmpty(); }


 public JLabel getTextFiledLabel()
 {return this.textFiledLabel;}


   private void createDirectionsPopupWindow()
   {

  String balloonText="<html><div align=\"justify\"><font color=\"#000000\"size=\"4\" face=\"Tahoma\">" +
                                "Δημιουργείστε τη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ που  θέλετε εισάγοντας  τους  όρους που<br>" +
                                "θα την αποτελούν.Επιλέξτε τα στοιχεία πατώντας τα αντίστοιχα κουμπιά.<br>" +
                                "Κάθε φορά που πατάτε ένα από τα κουμπιά ο αντίστοιχος όρος προστίθεται<br>" +
                                "στη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ που σχηματίζετε.Πηγαίνοντας το ποντίκι πάνω <br>" +
                                "από το αντίστοιχο κουμπί ή πλαίσιο με κουμπιά ενημερώνεστε για τη <br>" +
                                "λειτουργία του.Με τα κουμπιά <b>«Διαγραφή Τελευταίου Όρου»</b> και<br>" +
                                "<b>«Διαγραφή Συνθήκης»</b> μπορείτε να διαγράψετε τον τελευταίο όρο <br>" +
                                "της ΛΟΓΙΚΗΣ ΣΥΝΘΗΚΗΣ ή ολόκληρη τη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ,<br>" +
                                "αντίστοιχα. Η σειρά των όρων που αποτελούν τη ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ<br>" +
                                "καθορίζεται από τη σειρά εισαγωγής τους και δεν μπορεί να αλλάξει.<br>" +
                                "Για να αλλάξει η σειρά των όρων θα πρέπει οι όροι να διαγράφουν και να <br>" +
                                "εισαχθούν πάλι με τη σειρά που θέλετε.Με το κουμπί <b>«ΟΚ»</b> ελέγχεται η<br>" +
                                "ορθότητα της ΛΟΓΙΚΗΣ ΣΥΝΘΗΚΗΣ που σχηματίσατε και αν είναι σωστή<br>" +
                                "γίνεται αποδεκτή αλλιώς ενημερώνεστε για το/τα λάθος/η που περιέχει<br>" +
                                "ώστε να τη διορθώσετε.</font></div></html>";



       BalloonTipStyle edgedLook = new RoundedBalloonStyle(10,10,Color.WHITE, Color.BLUE);

     new BalloonTip(this.directionsButton,balloonText,edgedLook,Orientation.RIGHT_ABOVE,AttachLocation.SOUTHWEST,40,20,true  );

   }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectConstantBut = new javax.swing.JButton();
        selectVariableBut = new javax.swing.JButton();
        selectArrElemBut = new javax.swing.JButton();
        selectParameterBut = new javax.swing.JButton();
        selectFunctionBut = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        textFiledLabel = new javax.swing.JLabel();
        conditionTextField = new javax.swing.JTextField();
        DeleteConditionBut = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        equalBut = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        greateqBut = new javax.swing.JButton();
        greatBut = new javax.swing.JButton();
        leseqBut = new javax.swing.JButton();
        lesBut = new javax.swing.JButton();
        nonequalBut = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        addBut = new javax.swing.JButton();
        minusBut = new javax.swing.JButton();
        multBut = new javax.swing.JButton();
        divBut = new javax.swing.JButton();
        modBut = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        andBut = new javax.swing.JButton();
        orBut = new javax.swing.JButton();
        notBut = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        zeroBut = new javax.swing.JButton();
        oneBut = new javax.swing.JButton();
        twoBut = new javax.swing.JButton();
        lParBut = new javax.swing.JButton();
        rParBut = new javax.swing.JButton();
        fiveBut = new javax.swing.JButton();
        threeBut = new javax.swing.JButton();
        fourBut = new javax.swing.JButton();
        sixBut = new javax.swing.JButton();
        sevenBut = new javax.swing.JButton();
        eightBut = new javax.swing.JButton();
        nineBut = new javax.swing.JButton();
        pointBut = new javax.swing.JButton();
        lParenthesisLabel = new javax.swing.JLabel();
        rParenthesisLabel = new javax.swing.JLabel();
        deleteLastBut = new javax.swing.JButton();
        selectCharBut = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        trueButton = new javax.swing.JButton();
        falseButton = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        directionsButton = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();

        selectConstantBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.selectConstantBut.text")); // NOI18N
        selectConstantBut.setPreferredSize(new java.awt.Dimension(155, 25));
        selectConstantBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectConstantButActionPerformed(evt);
            }
        });

        selectVariableBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.selectVariableBut.text")); // NOI18N
        selectVariableBut.setPreferredSize(new java.awt.Dimension(155, 25));
        selectVariableBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectVariableButActionPerformed(evt);
            }
        });

        selectArrElemBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.selectArrElemBut.text")); // NOI18N
        selectArrElemBut.setPreferredSize(new java.awt.Dimension(155, 25));
        selectArrElemBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectArrElemButActionPerformed(evt);
            }
        });

        selectParameterBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.selectParameterBut.text")); // NOI18N
        selectParameterBut.setPreferredSize(new java.awt.Dimension(155, 25));
        selectParameterBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectParameterButActionPerformed(evt);
            }
        });

        selectFunctionBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.selectFunctionBut.text")); // NOI18N
        selectFunctionBut.setPreferredSize(new java.awt.Dimension(155, 25));
        selectFunctionBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFunctionButActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel20.text")); // NOI18N

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.errorLabel.text")); // NOI18N

        textFiledLabel.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.textFiledLabel.text")); // NOI18N

        conditionTextField.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.conditionTextField.text")); // NOI18N
        conditionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conditionTextFieldActionPerformed(evt);
            }
        });

        DeleteConditionBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.DeleteConditionBut.text")); // NOI18N
        DeleteConditionBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteConditionButActionPerformed(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jPanel7.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel21.text")); // NOI18N

        equalBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.equalBut.text")); // NOI18N
        equalBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalButActionPerformed(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel22.text")); // NOI18N

        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel23.text")); // NOI18N

        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel24.text")); // NOI18N

        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel25.text")); // NOI18N

        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel30.text")); // NOI18N

        greateqBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.greateqBut.text")); // NOI18N
        greateqBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greateqButActionPerformed(evt);
            }
        });

        greatBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.greatBut.text")); // NOI18N
        greatBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greatButActionPerformed(evt);
            }
        });

        leseqBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.leseqBut.text")); // NOI18N
        leseqBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leseqButActionPerformed(evt);
            }
        });

        lesBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.lesBut.text")); // NOI18N
        lesBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lesButActionPerformed(evt);
            }
        });

        nonequalBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.nonequalBut.text")); // NOI18N
        nonequalBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonequalButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel24)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(equalBut, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(nonequalBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(lesBut, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(greatBut, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(greateqBut, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(leseqBut, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(equalBut))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nonequalBut)
                            .addComponent(jLabel22))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(leseqBut)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greatBut)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greateqBut))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lesBut))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel23)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jPanel1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        addBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.addBut.text")); // NOI18N
        addBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButActionPerformed(evt);
            }
        });

        minusBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.minusBut.text")); // NOI18N
        minusBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusButActionPerformed(evt);
            }
        });

        multBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.multBut.text")); // NOI18N
        multBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multButActionPerformed(evt);
            }
        });

        divBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.divBut.text")); // NOI18N
        divBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                divButActionPerformed(evt);
            }
        });

        modBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.modBut.text")); // NOI18N
        modBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modButActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel13.text")); // NOI18N

        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel14.text")); // NOI18N

        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel16.text")); // NOI18N

        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel18.text")); // NOI18N

        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel19.text")); // NOI18N

        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel27.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel19)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(divBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minusBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(multBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(modBut, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBut)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minusBut)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(multBut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(divBut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modBut, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jPanel3.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        andBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.andBut.text")); // NOI18N
        andBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                andButActionPerformed(evt);
            }
        });

        orBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.orBut.text")); // NOI18N
        orBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orButActionPerformed(evt);
            }
        });

        notBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.notBut.text")); // NOI18N
        notBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel26.text")); // NOI18N

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel5.text")); // NOI18N

        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel12.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(orBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(andBut, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notBut)))
                .addGap(480, 480, 480)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(andBut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(orBut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(notBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(101, 101, 101))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        zeroBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.zeroBut.text")); // NOI18N
        zeroBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroButActionPerformed(evt);
            }
        });

        oneBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.oneBut.text")); // NOI18N
        oneBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneButActionPerformed(evt);
            }
        });

        twoBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.twoBut.text")); // NOI18N
        twoBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoButActionPerformed(evt);
            }
        });

        lParBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.lParBut.text")); // NOI18N
        lParBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lParButActionPerformed(evt);
            }
        });

        rParBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.rParBut.text")); // NOI18N
        rParBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rParButActionPerformed(evt);
            }
        });

        fiveBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.fiveBut.text")); // NOI18N
        fiveBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveButActionPerformed(evt);
            }
        });

        threeBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.threeBut.text")); // NOI18N
        threeBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeButActionPerformed(evt);
            }
        });

        fourBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.fourBut.text")); // NOI18N
        fourBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourButActionPerformed(evt);
            }
        });

        sixBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.sixBut.text")); // NOI18N
        sixBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixButActionPerformed(evt);
            }
        });

        sevenBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.sevenBut.text")); // NOI18N
        sevenBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sevenButActionPerformed(evt);
            }
        });

        eightBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.eightBut.text")); // NOI18N
        eightBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightButActionPerformed(evt);
            }
        });

        nineBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.nineBut.text")); // NOI18N
        nineBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nineButActionPerformed(evt);
            }
        });

        pointBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.pointBut.text")); // NOI18N
        pointBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pointButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(oneBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(twoBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(threeBut))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(fourBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fiveBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sixBut))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sevenBut)
                            .addComponent(lParBut))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(eightBut)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nineBut))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pointBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(zeroBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rParBut)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oneBut)
                    .addComponent(twoBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(threeBut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fourBut)
                    .addComponent(fiveBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sixBut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sevenBut)
                    .addComponent(eightBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nineBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zeroBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lParBut)
                    .addComponent(rParBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pointBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        lParenthesisLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        lParenthesisLabel.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.lParenthesisLabel.text")); // NOI18N

        rParenthesisLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        rParenthesisLabel.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.rParenthesisLabel.text")); // NOI18N

        deleteLastBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.deleteLastBut.text")); // NOI18N
        deleteLastBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLastButActionPerformed(evt);
            }
        });

        selectCharBut.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.selectCharBut.text")); // NOI18N
        selectCharBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCharButActionPerformed(evt);
            }
        });

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        trueButton.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.trueButton.text")); // NOI18N
        trueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trueButtonActionPerformed(evt);
            }
        });

        falseButton.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.falseButton.text")); // NOI18N
        falseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                falseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(trueButton)
                    .addComponent(falseButton))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trueButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(falseButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel28.text")); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel29.text")); // NOI18N

        directionsButton.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.directionsButton.text")); // NOI18N
        directionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directionsButtonActionPerformed(evt);
            }
        });

        jLabel31.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel31.text")); // NOI18N

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel32.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel32.text")); // NOI18N

        jLabel33.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel33.text")); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel34.setText(org.openide.util.NbBundle.getMessage(addCommandConditionPanel.class, "addCommandConditionPanel.jLabel34.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectConstantBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectVariableBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectCharBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectArrElemBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectFunctionBut, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectParameterBut, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                .addComponent(directionsButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textFiledLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lParenthesisLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conditionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rParenthesisLabel))
                            .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteLastBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteConditionBut, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel29))
                            .addComponent(jLabel28))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectVariableBut, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(selectCharBut, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectParameterBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(directionsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectConstantBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectArrElemBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectFunctionBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel20))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29)
                        .addGap(1, 1, 1)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFiledLabel)
                            .addComponent(conditionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lParenthesisLabel)
                            .addComponent(rParenthesisLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteLastBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DeleteConditionBut)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectConstantButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectConstantButActionPerformed
        addConstant();
}//GEN-LAST:event_selectConstantButActionPerformed

    private void selectVariableButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectVariableButActionPerformed
        addVariable();
}//GEN-LAST:event_selectVariableButActionPerformed

    private void selectArrElemButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectArrElemButActionPerformed
        addArrayElement(null);
}//GEN-LAST:event_selectArrElemButActionPerformed

    private void selectParameterButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectParameterButActionPerformed
        addParameter();
}//GEN-LAST:event_selectParameterButActionPerformed

    private void selectFunctionButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFunctionButActionPerformed
        addFunction();
}//GEN-LAST:event_selectFunctionButActionPerformed

    private void conditionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conditionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conditionTextFieldActionPerformed

    private void addButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButActionPerformed
        addText(addBut.getText());
}//GEN-LAST:event_addButActionPerformed

    private void minusButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusButActionPerformed
        addText(minusBut.getText());
}//GEN-LAST:event_minusButActionPerformed

    private void multButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multButActionPerformed
        addText(multBut.getText());
}//GEN-LAST:event_multButActionPerformed

    private void divButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divButActionPerformed
        addText(divBut.getText());
}//GEN-LAST:event_divButActionPerformed

    private void modButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modButActionPerformed
        addText(modBut.getText());
}//GEN-LAST:event_modButActionPerformed

    private void equalButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalButActionPerformed
        addText(equalBut.getText());
}//GEN-LAST:event_equalButActionPerformed

    private void nonequalButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonequalButActionPerformed
        addText(nonequalBut.getText());
}//GEN-LAST:event_nonequalButActionPerformed

    private void lesButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lesButActionPerformed
        addText(lesBut.getText());
}//GEN-LAST:event_lesButActionPerformed

    private void leseqButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leseqButActionPerformed
        addText(leseqBut.getText());
}//GEN-LAST:event_leseqButActionPerformed

    private void greatButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greatButActionPerformed
        addText(greatBut.getText());
}//GEN-LAST:event_greatButActionPerformed

    private void greateqButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greateqButActionPerformed
        addText(greateqBut.getText());
}//GEN-LAST:event_greateqButActionPerformed

    private void zeroButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroButActionPerformed
        addTextNoSpaces(zeroBut.getText());
}//GEN-LAST:event_zeroButActionPerformed

    private void oneButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneButActionPerformed
        addTextNoSpaces(oneBut.getText());
}//GEN-LAST:event_oneButActionPerformed

    private void twoButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoButActionPerformed
        addTextNoSpaces(twoBut.getText());
}//GEN-LAST:event_twoButActionPerformed

    private void lParButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lParButActionPerformed
        addText(lParBut.getText());
}//GEN-LAST:event_lParButActionPerformed

    private void rParButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rParButActionPerformed
        addText(rParBut.getText());
}//GEN-LAST:event_rParButActionPerformed

    private void fiveButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveButActionPerformed
        addTextNoSpaces(fiveBut.getText());
}//GEN-LAST:event_fiveButActionPerformed

    private void threeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeButActionPerformed
        addTextNoSpaces(threeBut.getText());
}//GEN-LAST:event_threeButActionPerformed

    private void fourButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourButActionPerformed
        addTextNoSpaces(fourBut.getText());
}//GEN-LAST:event_fourButActionPerformed

    private void sixButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixButActionPerformed
        addTextNoSpaces(sixBut.getText());
}//GEN-LAST:event_sixButActionPerformed

    private void sevenButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sevenButActionPerformed
        addTextNoSpaces(sevenBut.getText());
}//GEN-LAST:event_sevenButActionPerformed

    private void eightButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightButActionPerformed
        addTextNoSpaces(eightBut.getText());
}//GEN-LAST:event_eightButActionPerformed

    private void nineButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nineButActionPerformed
        addTextNoSpaces(nineBut.getText());
}//GEN-LAST:event_nineButActionPerformed

    private void pointButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pointButActionPerformed
        addTextNoSpaces(pointBut.getText());
}//GEN-LAST:event_pointButActionPerformed

    private void andButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_andButActionPerformed
        addText(andBut.getText());
}//GEN-LAST:event_andButActionPerformed

    private void orButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orButActionPerformed
        addText(orBut.getText());
}//GEN-LAST:event_orButActionPerformed

    private void notButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notButActionPerformed
        addText(notBut.getText());
}//GEN-LAST:event_notButActionPerformed

    private void trueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trueButtonActionPerformed
        addText(trueButton.getText());
}//GEN-LAST:event_trueButtonActionPerformed

    private void falseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_falseButtonActionPerformed
        addText(falseButton.getText());
}//GEN-LAST:event_falseButtonActionPerformed

    private void selectCharButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCharButActionPerformed
       addCharacter();
    }//GEN-LAST:event_selectCharButActionPerformed

    private void deleteLastButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLastButActionPerformed
        deleteLast();
}//GEN-LAST:event_deleteLastButActionPerformed

    private void DeleteConditionButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteConditionButActionPerformed
        clearAll();
}//GEN-LAST:event_DeleteConditionButActionPerformed

    private void directionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directionsButtonActionPerformed
               this.createDirectionsPopupWindow();
    }//GEN-LAST:event_directionsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteConditionBut;
    private javax.swing.JButton addBut;
    private javax.swing.JButton andBut;
    private javax.swing.JTextField conditionTextField;
    private javax.swing.JButton deleteLastBut;
    private javax.swing.JButton directionsButton;
    private javax.swing.JButton divBut;
    private javax.swing.JButton eightBut;
    private javax.swing.JButton equalBut;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton falseButton;
    private javax.swing.JButton fiveBut;
    private javax.swing.JButton fourBut;
    private javax.swing.JButton greatBut;
    private javax.swing.JButton greateqBut;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton lParBut;
    private javax.swing.JLabel lParenthesisLabel;
    private javax.swing.JButton lesBut;
    private javax.swing.JButton leseqBut;
    private javax.swing.JButton minusBut;
    private javax.swing.JButton modBut;
    private javax.swing.JButton multBut;
    private javax.swing.JButton nineBut;
    private javax.swing.JButton nonequalBut;
    private javax.swing.JButton notBut;
    private javax.swing.JButton oneBut;
    private javax.swing.JButton orBut;
    private javax.swing.JButton pointBut;
    private javax.swing.JButton rParBut;
    private javax.swing.JLabel rParenthesisLabel;
    private javax.swing.JButton selectArrElemBut;
    private javax.swing.JButton selectCharBut;
    private javax.swing.JButton selectConstantBut;
    private javax.swing.JButton selectFunctionBut;
    private javax.swing.JButton selectParameterBut;
    private javax.swing.JButton selectVariableBut;
    private javax.swing.JButton sevenBut;
    private javax.swing.JButton sixBut;
    private javax.swing.JLabel textFiledLabel;
    private javax.swing.JButton threeBut;
    private javax.swing.JButton trueButton;
    private javax.swing.JButton twoBut;
    private javax.swing.JButton zeroBut;
    // End of variables declaration//GEN-END:variables

}
