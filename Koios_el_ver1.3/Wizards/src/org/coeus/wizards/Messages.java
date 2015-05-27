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


package org.coeus.wizards;

import org.coeus.parsers.parserDefinitions;

/**
 *
 * @author Jrd
 */
public class Messages {

    /////////////CONSTANTS/////////////////
    public static final String ERR_CON_NAME_BL1="Το όνομα της ΣΤΑΘΕΡΑΣ δεν μπορεί να είναι κενό!";
    public static final String ERR_CON_NAME_BL2="Συμπληρώστε ένα όνομα στο πεδίο \"Όνομα Σταθεράς :\"";
    public static final String ERR_CON_NAME_LET1="Το όνομα της ΣΤΑΘΕΡΑΣ πρέπει να ξεκινά με γράμμα(χωρίς τόνους),δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_CON_NAME_LET2="Διορθώστε το όνομα στο πεδίο \"Όνομα Σταθεράς :\"";
    public static final String ERR_CON_NAME_LET3="Το όνομα της ΣΤΑΘΕΡΑΣ πρέπει να αποτελείται απο γράμματα(χωρίς τόνους),αριθμούς,δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_CON_NAME_RES="Το όνομα που εισάγατε αποτελεί δεσμευμένη λέξη και δεν μπορεί να χρησιμοποιηθεί!";
    public static final String ERR_CON_NAME_USE="Το όνομα που εισάγατε χρησιμοποιείται ήδη ως όνομα για ";
    public static final String ERR_CON_NAME_USE1="στην ίδια περιοχή εμβέλειας - ";
    public static final String ERR_CON_NAME_USE2="με εμβέλεια: ";
    public static final String ERR_CON_VALUE_EM1="Η αρχική τιμή της ΣΤΑΘΕΡΑΣ δεν μπορεί να είναι κενή!";
    public static final String ERR_CON_VALUE_EM2="Η ΣΤΑΘΕΡΑ πρέπει να παίρνει τιμή κατα τη δήλωσή της!";
    public static final String ERR_CON_VALUE_NUM1="Η τιμή μιας ΑΚΕΡΑΙΑΣ ΣΤΑΘΕΡΑΣ πρέπει να περιέχει μόνο αριθμόυς!";
    public static final String ERR_CON_VALUE_NUM2="Διορθώστε την τιμή που δώσατε στο πεδίο \"Αρχική Τιμή Σταθεράς :\"";
    public static final String ERR_CON_VALUE_OOL1="Η τιμή μιας ΑΚΕΡΑΙΑΣ ΣΤΑΘΕΡΑΣ πρέπει να είναι μεταξύ "+ Integer.MIN_VALUE + " και "+Integer.MAX_VALUE+" !";
    public static final String ERR_CON_VALUE_OOL2="Το ακέραιο μέρος μιας ΠΡΑΓΜΑΤΙΚΗΣ ΣΤΑΘΕΡΑΣ πρέπει να περιέχει μόνο αριθμόυς!";
    public static final String ERR_CON_VALUE_OOL3="Το δεκαδικό μέρος μιας ΠΡΑΓΜΑΤΙΚΗΣ ΣΤΑΘΕΡΑΣ πρέπει να περιέχει μόνο αριθμόυς!";
    public static final String ERR_CON_VALUE_OOL4="Η τιμή μιας ΣΤΑΘΕΡΑ ΧΑΡΑΚΤΗΡΑΣ πρέπει να περιέχει μόνον ένα χαρακτήρα!";
    public static final String ERR_CON_VALUE_OOL4A="Το πλήθος των χαρακτήρων που έχετε εισάγει ειναι: ";
    public static final String ERR_CON_VALUE_OOL5="Η τιμή μιας ΠΡΑΓΜΑΤΙΚΗΣ ΣΤΑΘΕΡΑΣ πρέπει να είναι μεταξύ "+ Float.MIN_VALUE + " και "+Float.MAX_VALUE+" !";
    public static final String ERR_CON_NAME_PARM1=" την";
    public static final String ERR_CON_NAME_PARM2="η παράμετρο εισόδου στη ";

    public static final String INFO_CON1a="Δημιουργήθηκε ΣΤΑΘΕΡΑ τύπου ";
    public static final String INFO_CON1b="Ενημερώθηκε η ΣΤΑΘΕΡΑ τύπου ";
    public static final String INFO_CON2=" με όνομα " ;
    public static final String INFO_CON3=" αρχική τιμή ";

    public static final String INFO_CON_PANEL1="Για το όνομα της ΣΤΑΘΕΡΑΣ προτιμήστε ΚΕΦΑΛΑΙΑ γράμματα,χωρίς τους τόνους";
    public static final String INFO_CON_PANEL2="Εισάγετε τιμή που θέλετε να αποδώστε στη ΣΤΑΘΕΡΑ στο πεδίο \"Αρχική Τιμή Σταθεράς :\"";

    //////////////VARIABLES///////////////
    public static final String ERR_VAR_NAME_BL1="Το όνομα της ΜΕΤΑΒΛΗΤΗΣ δεν μπορεί να είναι κενό!";
    public static final String ERR_VAR_NAME_BL2="Συμπληρώστε ένα όνομα στο πεδίο \"Όνομα Μεταβλητής :\"";
    public static final String ERR_VAR_NAME_LET1="Το όνομα της ΜΕΤΑΒΛΗΤΗΣ πρέπει να ξεκινά με γράμμα(χωρίς τόνους),δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_VAR_NAME_LET2="Διορθώστε το όνομα στο πεδίο \"Όνομα Μεταβλητής :\"";
    public static final String ERR_VAR_NAME_LET3="Το όνομα της ΜΕΤΑΒΛΗΤΗΣ πρέπει να αποτελείται απο γράμματα(χωρίς τόνους),αριθμούς,δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_VAR_NAME_RES="Το όνομα που εισάγατε αποτελεί δεσμευμένη λέξη και δεν μπορεί να χρησιμοποιηθεί!";
    public static final String ERR_VAR_NAME_USE="Το όνομα που εισάγατε χρησιμοποιείται ήδη ως όνομα για ";
    public static final String ERR_VAR_NAME_USE1="στην ίδια περιοχή εμβέλειας - ";
    public static final String ERR_VAR_NAME_USE2="με εμβέλεια: ";
    public static final String ERR_VAR_VALUE_EM1="Η αρχική τιμή της ΜΕΤΑΒΛΗΤΗΣ δεν μπορεί να είναι κενή!";
    public static final String ERR_VAR_VALUE_EM2="Έχετε επιλέξει να αποδώσετε αρχική τιμή στη ΜΕΤΑΒΛΗΤΗ!\nΑν δεν επιθυμείτε να δώσετε αρχική τιμή, επιλέξτε \"Μεταβλητή χωρίς Αρχική Τιμή\"";
    public static final String ERR_VAR_VALUE_NUM1="Η τιμή μιας ΑΚΕΡΑΙΑΣ ΜΕΤΑΒΛΗΤΗΣ πρέπει να περιέχει μόνο αριθμόυς!";
    public static final String ERR_VAR_VALUE_NUM2="Διορθώστε την τιμή που δώσατε στο πεδίο \"Αρχική Τιμή Μεταβλητής :\"";
    public static final String ERR_VAR_VALUE_OOL1="Η τιμή μιας ΑΚΕΡΑΙΑΣ ΜΕΤΑΒΛΗΤΗΣ πρέπει να είναι μεταξύ "+ Integer.MIN_VALUE + " και "+Integer.MAX_VALUE+" !";
    public static final String ERR_VAR_VALUE_OOL2="Το ακέραιο μέρος μιας ΠΡΑΓΜΑΤΙΚΗΣ ΜΕΤΑΒΛΗΤΗΣ πρέπει να περιέχει μόνο αριθμόυς!";
    public static final String ERR_VAR_VALUE_OOL3="Το δεκαδικό μέρος μιας ΠΡΑΓΜΑΤΙΚΗΣ ΜΕΤΑΒΛΗΤΗΣ πρέπει να περιέχει μόνο αριθμόυς!";
    public static final String ERR_VAR_VALUE_OOL4="Η τιμή μιας ΜΕΤΑΒΛΗΤΗΣ ΧΑΡΑΚΤΗΡΑΣ πρέπει να περιέχει μόνον ένα χαρακτήρα!";
    public static final String ERR_VAR_VALUE_OOL4A="Το πλήθος των χαρακτήρων που έχετε εισάγει ειναι: ";
    public static final String ERR_VAR_VALUE_OOL5="Η τιμή μιας ΠΡΑΓΜΑΤΙΚΗΣ ΜΕΤΑΒΛΗΤΗΣ πρέπει να είναι μεταξύ "+ Float.MIN_VALUE + " και "+Float.MAX_VALUE+" !";
    public static final String ERR_VAR_NAME_PARM1=" την";
    public static final String ERR_VAR_NAME_PARM2="η παράμετρο εισόδου στη ";

    public static final String INFO_VAR1a="Δημιουργήθηκε ΜΕΤΑΒΛΗΤΗ τύπου ";
    public static final String INFO_VAR1b="Ενημερώθηκε η ΜΕΤΑΒΛΗΤΗ τύπου ";
    public static final String INFO_VAR2=" με όνομα " ;
    public static final String INFO_VAR3=" και αρχική τιμή ";
    public static final String INFO_VAR4=" χωρίς αρχική τιμή!";

    public static final String INFO_VAR_PANEL1="Για το όνομα της ΜΕΤΑΒΛΗΤΗΣ προτιμήστε ΚΕΦΑΛΑΙΑ γράμματα,χωρίς τους τόνους";
    public static final String INFO_VAR_PANEL2="Εισάγετε τιμή που θέλετε να αποδώστε στη ΜΕΤΑΒΛΗΤΗ στο πεδίο \"Αρχική Τιμή Μεταβλητής :\"";



    //////////////ARRAYS///////////////
    public static final String ERR_ARR_NAME_BL1="Το όνομα του ΠΙΝΑΚΑ δεν μπορεί να είναι κενό!";
    public static final String ERR_ARR_NAME_BL2="Συμπληρώστε ένα όνομα στο πεδίο \"Όνομα Πίνακα :\"";
    public static final String ERR_ARR_NAME_LET1="Το όνομα του ΠΙΝΑΚΑ πρέπει να ξεκινά με γράμμα(χωρίς τόνους),δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_ARR_NAME_LET2="Διορθώστε το όνομα στο πεδίο \"Όνομα Πίνακα :\"";
    public static final String ERR_ARR_NAME_LET3="Το όνομα του ΠΙΝΑΚΑ πρέπει να αποτελείται απο γράμματα(χωρίς τόνους),αριθμούς,δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_ARR_NAME_RES="Το όνομα που εισάγατε αποτελεί δεσμευμένη λέξη και δεν μπορεί να χρησιμοποιηθεί!";
    public static final String ERR_ARR_NAME_USE="Το όνομα που εισάγατε χρησιμοποιείται ήδη ως όνομα για ";
    public static final String ERR_ARR_NAME_USE1="στην ίδια περιοχή εμβέλειας - ";
    public static final String ERR_ARR_NAME_USE2="με εμβέλεια: ";
    public static final String ERR_ARR_VALUE_EM1="Οι αρχικές τιμές του ΠΙΝΑΚΑ δεν μπορούν να είναι κενές!";
    public static final String ERR_ARR_VALUE_EM2="Έχετε επιλέξει να αποδώσετε αρχικές τιμές στον ΠΙΝΑΚΑ!\nΑν δεν επιθυμείτε να δώσετε αρχικές τιμές, επιλέξτε \"Πίνακας χωρίς Αρχικές Τιμές\"";
    public static final String ERR_ARR_VALUE_NUM1="Οι τιμές σε ενα ΠΙΝΑΚΑ ΑΚΕΡΑΙΩΝ πρέπει να περιέχούν μόνο ΑΚΕΡΑΙΟΥΣ αριθμούς!";
    //public static final String ERR_ARR_VALUE_NUM2="Διορθώστε την τιμή που δώσατε στο πεδίο \"Αρχικές Τιμές Πίνακα :\"";
    public static final String ERR_ARR_VALUE_OOL1="Οι τιμές σε ένα ΠΙΝΑΚΑ ΑΚΕΡΑΙΩΝ πρέπει να είναι μεταξύ "+ Integer.MIN_VALUE + " και "+Integer.MAX_VALUE+" !";
    public static final String ERR_ARR_VALUE_OOL2="Οι τιμές σε ένα ΠΙΝΑΚΑ ΠΡΑΓΜΑΤΙΚΩΝ πρέπει να περιέχουν μόνο ΠΡΑΓΜΑΤΙΚΟΥΣ αριθμούς!";
    public static final String ERR_ARR_VALUE_OOL3="H τιμή σε ένα ΠΙΝΑΚΑ ΠΡΑΓΜΑΤΙΚΩΝ πρέπει να περιέχει μόνο 1 υποδιαστολή \".\"";
    public static final String ERR_ARR_VALUE_OOL4="Κάθε τιμή σε ενα ΠΙΝΑΚΑ ΧΑΡΑΚΤΗΡΩΝ πρέπει να περιέχει μόνον ένα χαρακτήρα!";
    public static final String ERR_ARR_VALUE_OOL4A="Το πλήθος των χαρακτήρων που έχετε εισάγει ειναι: ";
    public static final String ERR_ARR_VALUE_OOL5="Οι τιμές σε ενα ΠΙΝΑΚΑ ΠΡΑΓΜΑΤΙΚΩΝ πρέπει να είναι μεταξύ "+ Float.MIN_VALUE + " και "+Float.MAX_VALUE+" !";
    public static final String ERR_ARR_DIM1_EM="Το μέγεθος της 1ης Διάστασης του ΠΙΝΑΚΑ δεν μπορεί να έιναι κενό!";
    public static final String ERR_ARR_VALUE_BOOL1="Οι τιμές σε ένα ΠΙΝΑΚΑ ΛΟΓΙΚΩΝ πρέπει να έιναι \""+parserDefinitions.TRUE+"\" ή \""+parserDefinitions.FALSE+"\"";
    public static final String ERR_ARR_VALUE_BOOL2="Διορθώστε την τιμή του στοιχείου του ΠΙΝΑΚΑ στη θέση: ";
    public static final String ERR_ARR_DIM1_INT="Το μέγεθος της 1ης Διάστασης του ΠΙΝΑΚΑ πρέπει να είναι ΑΚΕΡΑΙΟΣ ΑΡΙΘΜΟΣ και μεγαλύτερος του 1";
    public static final String ERR_ARR_DIM1_EM1="Διόρθωστε την τιμή στο πεδίο \"Μέγεθος 1ης Διάστασης :\"";
    public static final String ERR_ARR_DIM2_EM="Το μέγεθος της 2ης Διάστασης του ΠΙΝΑΚΑ δεν μπορεί να έιναι κενό!";
    public static final String ERR_ARR_DIM2_INT="Το μέγεθος της 2ης Διάστασης του ΠΙΝΑΚΑ πρέπει να είναι ΑΚΕΡΑΙΟΣ ΑΡΙΘΜΟΣ  και μεγαλύτερος του 1";
    public static final String ERR_ARR_DIM2_EM1="Διόρθωστε την τιμή στο πεδίο \"Μέγεθος 2ης Διάστασης :\"";
    public static final String ERR_ARR_NAME_PARM1=" την";
    public static final String ERR_ARR_NAME_PARM2="η παράμετρο εισόδου στη ";

    public static final String INFO_ARR1a="Δημιουργήθηκε ΠΙΝΑΚΑΣ τύπου ";
    public static final String INFO_ARR1b="Ενημερώθηκε ο ΠΙΝΑΚΑΣ τύπου ";
    public static final String INFO_ARR2=" με όνομα " ;
    public static final String INFO_ARR3=" και αρχικές τιμές! ";
    public static final String INFO_ARR4=" χωρίς αρχικές τιμές!";

    public static final String INFO_ARR_PANEL1="Για το όνομα του ΠΙΝΑΚΑΣ προτιμήστε ΚΕΦΑΛΑΙΑ γράμματα,χωρίς τους τόνους";
    public static final String INFO_ARR_PANEL2="Εισάγετε τιμές που θέλετε να αποδώστε στο ΠΙΝΑΚΑ στα αντίστοιχα πεδία";



    /////////////FUNCTIONS/////////////////
    public static final String ERR_FUN_NAME_BL1="Το όνομα της ΣΥΝΑΡΤΗΣΗΣ δεν μπορεί να είναι κενό!";
    public static final String ERR_FUN_NAME_BL2="Συμπληρώστε ένα όνομα στο πεδίο \"Όνομα Συνάρτησης :\"";
    public static final String ERR_FUN_NAME_LET1="Το όνομα της ΣΥΝΑΡΤΗΣΗΣ πρέπει να ξεκινά με γράμμα(χωρίς τόνους),δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_FUN_NAME_LET2="Διορθώστε το όνομα στο πεδίο \"Όνομα Συνάρτησης :\"";
    public static final String ERR_FUN_NAME_LET3="Το όνομα της ΣΥΝΑΡΤΗΣΗΣ πρέπει να αποτελείται απο γράμματα(χωρίς τόνους),αριθμούς,δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_FUN_NAME_RES="Το όνομα που εισάγατε αποτελεί δεσμευμένη λέξη και δεν μπορεί να χρησιμοποιηθεί!";
    public static final String ERR_FUN_NAME_USE="Το όνομα που εισάγατε χρησιμοποιείται ήδη ως όνομα για ";
    public static final String ERR_FUN_NAME_USE1="\n";//"στην ίδια περιοχή εμβέλειας : ΓΕΝΙΚΗ !\n";


    public static final String ERR_FUN_ARGUEMENT_EM1="To όνομα μιας τυπικής παραμέτρου εισόδου δεν μπορεί να είναι κενό!";
    public static final String ERR_FUN_ARGUEMENT_EM2="Συμπληρώστε το όνομα στο πεδίο \"Όνομα Παραμέτρου\" της ";
    public static final String ERR_FUN_ARGUEMENT_LET1="To όνομα μιας τυπικής παραμέτρου εισόδου πρέπει να ξεκινά με(χωρίς τόνους),δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_FUN_ARGUEMENT_LET2="Διορθώστε το όνομα στο πεδίο \"Όνομα Παραμέτρου\" της ";
    public static final String ERR_FUN_ARGUEMENT_LET3="To όνομα μιας τυπικής παραμέτρου εισόδου πρέπει να αποτελείται απο γράμματα(χωρίς τόνους),αριθμούς,δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_FUN_ARGUEMENT_RES="Το όνομα που εισάγατε αποτελεί δεσμευμένη λέξη και δεν μπορεί να χρησιμοποιηθεί!";
    public static final String ERR_FUN_ARGUEMENT_USE="Το όνομα που εισάγατε χρησιμοποιείται ήδη ως όνομα για ";
    public static final String ERR_FUN_ARGUEMENT_USE1="Το όνομα που εισάγατε χρησιμοποιείται ήδη ως όνομα για τη συνάρτηση!";
    public static final String ERR_FUN_ARGUEMENT_USE2="Το όνομα που εισάγατε χρησιμοποιείται ήδη ως όνομα για τη ";
    public static final String ERR_FUN_ARGUEMENT_UPDTAE_CANCELED="\nΗ μετβολή της παραμέτρου ακυρώθηκε!";

    public static final String INFO_FUN1a="Δημιουργήθηκε ΣΥΝΑΡΤΗΣΗ τύπου ";
    public static final String INFO_FUN1b="Ενημερώθηκε η ΣΥΝΑΡΤΗΣΗ τύπου ";
    public static final String INFO_FUN2=" με όνομα " ;
    public static final String INFO_FUN3=" και τυπικές παραμέτρους εισόδου ";
    public static final String INFO_FUN4=" χωρίς τυπικές παραμέτρους εισόδου !";

    public static final String INFO_FUN_PANEL1="Για το όνομα της ΣΥΝΑΡΤΗΣΗΣ προτιμήστε ΚΕΦΑΛΑΙΑ γράμματα,χωρίς τους τόνους";
    public static final String INFO_FUN_PANEL2="Συμπληρώστε τους τύπους και τα ονόματα των τυπικών παραμέτρων εισόδου";



    /////////////PROCEDURES/////////////////
    public static final String ERR_PRO_NAME_BL1="Το όνομα της ΔΙΑΔΙΚΑΣΙΑΣ δεν μπορεί να είναι κενό!";
    public static final String ERR_PRO_NAME_BL2="Συμπληρώστε ένα όνομα στο πεδίο \"Όνομα Διαδικασίας :\"";
    public static final String ERR_PRO_NAME_LET1="Το όνομα της ΔΙΑΔΙΚΑΣΙΑΣ πρέπει να ξεκινά με γράμμα(χωρίς τόνους),δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_PRO_NAME_LET2="Διορθώστε το όνομα στο πεδίο \"Όνομα Διαδικασίας :\"";
    public static final String ERR_PRO_NAME_LET3="Το όνομα της ΔΙΑΔΙΚΑΣΙΑΣ πρέπει να αποτελείται απο γράμματα(χωρίς τόνους),αριθμούς,δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_PRO_NAME_RES="Το όνομα που εισάγατε αποτελεί δεσμευμένη λέξη και δεν μπορεί να χρησιμοποιηθεί!";
    public static final String ERR_PRO_NAME_USE="Το όνομα που εισάγατε χρησιμοποιείται ήδη ως όνομα για ";
    public static final String ERR_PRO_NAME_USE1="\n";//"στην ίδια περιοχή εμβέλειας : ΓΕΝΙΚΗ !\n";

    public static final String ERR_PRO_ARGUEMENT_EM1="To όνομα μιας τυπικής παραμέτρου εισόδου δεν μπορεί να είναι κενό!";
    public static final String ERR_PRO_ARGUEMENT_EM2="Συμπληρώστε το όνομα στο πεδίο \"Όνομα Παραμέτρου\" της ";
    public static final String ERR_PRO_ARGUEMENT_LET1="To όνομα μιας τυπικής παραμέτρου εισόδου πρέπει να ξεκινά με γράμμα(χωρίς τόνους),δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_PRO_ARGUEMENT_LET2="Διορθώστε το όνομα στο πεδίο \"Όνομα Παραμέτρου\" της ";
    public static final String ERR_PRO_ARGUEMENT_LET3="To όνομα μιας τυπικής παραμέτρου εισόδου πρέπει να αποτελείται απο γράμματα,(χωρίς τόνους),αριθμούς,δολάριο($) ή κάτω παύλα(_)!";
    public static final String ERR_PRO_ARGUEMENT_RES="Το όνομα που εισάγατε αποτελεί δεσμευμένη λέξη και δεν μπορεί να χρησιμοποιηθεί!";
    public static final String ERR_PRO_ARGUEMENT_USE="Το όνομα που εισάγατε χρησιμοποιείται ήδη ως όνομα για ";
    public static final String ERR_PRO_ARGUEMENT_USE1="Το όνομα που εισάγατε χρησιμοποιείται ήδη ως όνομα για τη διαδικασία!";
    public static final String ERR_PRO_ARGUEMENT_USE2="Το όνομα που εισάγατε χρησιμοποιείται ήδη ως όνομα για τη ";
    public static final String ERR_PRO_ARGUEMENT_UPDTAE_CANCELED="\nΗ μετβολή της παραμέτρου ακυρώθηκε!";

    public static final String INFO_PRO1a="Δημιουργήθηκε ΔΙΑΔΙΚΑΣΙΑ ";
    public static final String INFO_PRO1b="Ενημερώθηκε η ΔΙΑΔΙΚΑΣΙΑ ";
    public static final String INFO_PRO2=" με όνομα " ;
    public static final String INFO_PRO3=" και τυπικές παραμέτρους εισόδου ";
    public static final String INFO_PRO4=" χωρίς τυπικές παραμέτρους εισόδου !";

    public static final String INFO_PRO_PANEL1="Για το όνομα της ΔΙΑΔΙΚΑΣΙΑΣ προτιμήστε ΚΕΦΑΛΑΙΑ γράμματα,χωρίς τους τόνους";
    public static final String INFO_PRO_PANEL2="Συμπληρώστε τους τύπους και τα ονόματα των τυπικών παραμέτρων εισόδου";

 ///////////READ//////////////////
    public static final String INFO_READ_PANEL1="";
    public static final String INFO_READ1="Δημιουργήθηκε μια εντολή \"ΔΙΑΒΑΣΕ\"!\nΜε αυτήν την εντολή θα διαβαστούν ";
    public static final String INFO_READ2=" τιμές απο το πληκτρολόγιο και θα αποθηκευτουν αντίστοιχα στα στοιχεία: \n";

    public static final String ERR_READ_EMPTY="Δεν έχετε εισάγει κανένα στοιχείο!\nΠροσθέστε τουλάχιστον ενα στοιχείο στην εντολή ΔΙΑΒΑΣΕ!";

    
    ///////////WRITE//////////////////
    public static final String INFO_WRITE_PANEL1="";
    public static final String INFO_WRITE1="Δημιουργήθηκε μια εντολή \"ΓΡΑΨΕ\"!\nΜε αυτήν την εντολή θα εμφανιστούν ";
    public static final String INFO_WRITE2=" τιμές και μυνήμτα στην οθόνη, απο τα αντίστοιχα στοιχεία: \n";

    public static final String ERR_WRITE_EMPTY="Δεν έχετε εισάγει κανένα στοιχείο!\nΠροσθέστε τουλάχιστον ενα στοιχείο στην εντολή ΔΙΑΒΑΣΕ!";


 ///////////CALL//////////////////
    public static final String INFO_CALL_PANEL1="Επιλεξτε τη ΔΙΑΔΙΚΑΣΙΑ που θέλετε να καλέσετε";
    public static final String INFO_CALL1="Δημιουργήθηκε μια εντολή \"ΚΑΛΕΣΕ\"!\nΜε αυτήν την εντολή θα κληθεί η ΔΙΑΔΙΚΑΣΙΑ ";
    public static final String INFO_CALL2=" με τις αντίστοιχες πραγματικές παραμέτρους εισόδου : \n";

    public static final String ERR_CALL_EMPTY="Δεν έχετε εισάγει κανένα στοιχείο!\nΠροσθέστε τουλάχιστον ενα στοιχείο στην εντολή ΚΑΛΕΣΕ!";

    public static final String INFO_FUNCCALL_PANEL1="Επιλεξτε τη ΣΥΝΑΡΤΗΣΗ που θέλετε να χρησιμοποιήσετε";

  //////////////ASSIGN////////////////////
    public static final String INFO_ASSIGN_PANEL1="Επιλεξτε το στοιχείο στο οποίο θέλετε να αποθηκεύσετε την τιμή που θα δημιουργήσετε";
    public static final String INFO_ASSIGN1="Δημιουργήθηκε μια εντολή \"ΑΝΑΘΕΣΕ\"!\nΑυτή η εντολή θα αναθέσει στο ";
    public static final String INFO_ASSIGN2="τον/τη ";// τιμή : \n";


////////////RETURN/////////////////
    public static final String INFO_RETURN_PANEL1="Επιλεξτε την παράσταση που θέλετε να επιστρέφει η ΣΥΝΑΡΤΗΣΗ ";
    public static final String INFO_RETURN1a="Δημιουργήθηκε μια εντολή \"ΕΠΕΣΤΡΕΨΕ\"!\nΜε αυτήν την εντολή η ΣΥΝΑΡΤΗΣΗ ";
    public static final String INFO_RETURN1b="Ενημερώθηκε μια εντολή \"ΕΠΕΣΤΡΕΨΕ\"!\nΜε αυτήν την εντολή η ΣΥΝΑΡΤΗΣΗ ";
    public static final String INFO_RETURN2=" θα επιστρέφει τον/την \n";

////////////WHILE/////////////////
    public static final String INFO_WHILE_PANEL1="Επιλεξτε την ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ που θέλετε να ισχύει για την εντολή ";
    public static final String INFO_WHILE1a="Δημιουργήθηκε μια εντολή \"";
    public static final String INFO_WHILE1b="Ενημερώθηκε μια εντολή \"";
    public static final String INFO_WHILE2="!\nΟι εντολές που ανήκουν σε αυτήν την εντολή θα εκετλόυνται επαναληπτικά,\nΟΣΟ ισχύει η ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ: ";

    public static final String INFO_DOWHILE2="!\nΟι εντολές που ανήκουν σε αυτήν την εντολή θα εκτελεστούν οποσδήποτε μια φορά,\nκαι θα συνεχίσουν να εκετλόυνται, ΟΣΟ ισχύει η ΛΟΓΙΚΗ ΣΥΝΘΗΚΗ: ";


    ////////////FOR/////////////////
    public static final String INFO_FOR_PANEL1="Επιλεξτε την ΑΡΧΙΚΗ και ΤΕΛΙΚΗ ΤΙΜΗ και ΒΗΜΑ της εντολής ΓΙΑ";
    public static final String INFO_FOR1="Δημιουργήθηκε μια εντολή \"ΓΙΑ..ΜΕΧΡΙ\"!\nΜε ΑΡΧΙΚΗ ΤΙΜΗ ";
    public static final String INFO_FOR2="\nΤΕΛΙΚΗ ΤΙΜΗ ";
    public static final String INFO_FOR3="\n και ΒΗΜΑ ";
    public static final String INFO_FOR4="\nΟι εντολές που ανήκουν στη εντολή ΓΙΑ..ΜΕΧΡΙ θα εκτελεστούν τόσες φορες,\n" +
            "όσες χρειάζεται η ΑΡΧΙΚΗ ΤΙΜΗ να γίνει ίση με την ΤΕΛΙΚΗ, μεταβαλλόμενη κάθε φορά κατα ΒΗΜΑ!";


    ////////////IF/////////////////
    public static final String INFO_IF_PANEL1="Εισάγετε τις συνθήκες για τα τμήματα ΑΝ,ΑΛΛΙΩΣ ΑΝ και ΑΝ";
    public static final String INFO_IF1="Δημιουργήθηκε μια εντολή \"ΑΝ..ΑΛΛΙΩΣ\"!\nΜε τα παρακάτω τμήματα " +
            "και τις αντίστοιχές συνθήκες:\n";
    public static final String INFO_IF2="\nΟι εντολές που βρίσκονται σε κάθε τμήμα θα εκτελεστούν αν ισχύει η " +
            "αντίστοιχη συνθήκη.";

//    public static final String INFO_IF3="\n και ΒΗΜΑ: ";
//    public static final String INFO_IF4="\nΟι εντολές που ανήκουν στη εντολή ΓΙΑ θα εκτελεστούν τόσες φορες";

 public static final String ERR_ASS_EMPTY="Δεν επιλέχθηκε στοιχείο για την εντολή \"ΑΝΑΘΕΣΕ\"!\nΚάντε μια επιλογή για να αναθέσετε μια τιμή ή πατήτστε το ΑΚΥΡΟ.";

}
