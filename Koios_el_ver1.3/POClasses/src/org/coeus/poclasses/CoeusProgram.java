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


package org.coeus.poclasses;

import org.coeus.wizards.WizardsDefinitions;

/**
 *
 * @author Jrd
 */
public class CoeusProgram {

    public static final String TRUE="ΑΛΗΘΗΣ";
    public static final String FALSE= "ΨΕΥΔΗΣ";

    ///////////Program///////////
    public static final String PROGRAM1="ΠΡΟΓΡΑΜΜΑ ";
    public static final String PROGRAM2="\nΤΕΛΟΣ ΠΡΟΓΡΑΜΜΑΤΟΣ\n";

    public static final String MAIN_PROC=WizardsDefinitions.MAIN_PROC;
    //////////Constant-Variable-Array/////
    public static final String CONSTANT="ΣΤΑΘΕΡΑ ";
    public static final String VARIABLE="ΜΕΤΑΒΛΗΤΗ ";
    public static final String ARRAY="ΠΙΝΑΚΑΣ ";

    ////////////Assing Initial Value
    public static final String ASSIGN_IV = " ΜΕ ΑΡΧΙΚΗ ΤΙΜΗ ";
    public static final String ASSIGN_IVS = " ΜΕ ΑΡΧΙΚΕΣ ΤΙΜΕΣ ";

    /////////PROCEDURE-FUNCTION/////
    public static final String PROCEDURE="ΔΙΑΔΙΚΑΣΙΑ";
    public static final String PROCEDURE_ENDPROC="ΤΕΛΟΣ ΔΙΑΔΙΚΑΣΙΑΣ ";
    public static final String PROCEDURE_ENDΜΑΙΝ="ΤΕΛΟΣ ΚΥΡΙΩΣ ΔΙΑΔΙΚΑΣΙΑΣ";
    public static final String FUNCTION="ΣΥΝΑΡΤΗΣΗ";
    public static final String FUNCTION2="ΤΕΛΟΣ ΣΥΝΑΡΤΗΣΗΣ ";
    public static final String PARAMETRES ="ΜΕ ΠΑΡΑΜΕΤΡΟΥΣ";
 
   
    
    
    public static final String READ="ΔΙΑΒΑΣΕ";

    public static final String WRITE="ΓΡΑΨΕ";

    public static final String CALL="ΚΑΛΕΣΕ ΤΗ ΔΙΑΔΙΚΑΣΙΑ";

    public static final String ASSIGN="ΑΝΑΘΕΣΕ ΣΤΟ ";
    public static final String ASSIGN1=" ΤΗΝ ΠΑΡΑΣΤΑΣΗ ";

    public static final String RETURN="ΕΠΕΣΤΡΕΨΕ";//" ΤΗΝ ΠΑΡΑΣΤΑΣΗ";

    public static final String WHILE1= "ΟΣΟ ΙΧΥΕΙ Η ΣΥΝΘΗΚΗ";
    public static final String WHILE2="ΕΠΑΝΑΛΕΑΒΕ\n";
    public static final String WHILE3="ΤΕΛΟΣ_ΟΣΟ\n";

    public static final String DOWHILE1= "ΚΑΝΕ\n";
    public static final String DOWHILE2="ΟΣΟ ΙΧΥΕΙ Η ΣΥΝΘΗΚΗ";

    public static final String FOR1= "ΓΙΑ ";
  //  public static final String FOR2=" ΑΠΟ ";
    public static final String FOR3=" ΜΕΧΡΙ ";
    public static final String FOR4=" ΜΕ ΒΗΜΑ ";
    public static final String FOR5="ΤΕΛΟΣ ΓΙΑ\n";

    public static final String IF1= "ΑΝ ";
    public static final String IF2="  ";
    public static final String ELSEIF="ΑΛΛΙΩΣ ΑΝ ";
    public static final String ELSE="ΑΛΛΙΩΣ ";
    public static final String ENDIF="ΤΕΛΟΣ ΑΝ\n";
}
