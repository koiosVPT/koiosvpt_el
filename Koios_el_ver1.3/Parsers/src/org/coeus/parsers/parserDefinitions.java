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


package org.coeus.parsers;

/**
 *
 * @author Jrd
 */
public class parserDefinitions {

    public static final String IDENTIFIER="ΑΝΑΓΝΩΡΙΣΤΙΚΟ";
    public static final String NUMBER="ΑΡΙΘΜΟΣ";
    public static final String AND="ΚΑΙ";
    public static final String NOT="ΟΧΙ";
    public static final String OR="Η";
    public static final String TRUE="ΑΛΗΘΗΣ";
    public static final String FALSE="ΨΕΥΔΗΣ";

    ///////////////////ERROR MESSAGES////

    public static final String LEX_MISSING_EQUAL="Αναμένεται ο χαρακτήρα \'=\' - Βρέθηκε ο χαρακτήρας: ";
    public static final String LEX_UNEXPECTED_CHAR="Μη αναμενόμενος χαρακτήρας: ";
    public static final String LEX_2_DOTS="Βρέθηκαν 2 υποδιαστιλές(.) στον ίδιο αριθμό!";
    public static final String PAR_WRONG_CHAR="Βρέθηκε λάθος χαρακτήρας: ";
    public static final String PAR_INPOS=" στη θέση ";
    public static final String RIGHT_PAR_MISSING="Λείπει δεξιά παρένθεση \')\'";
    public static final String LEFT_PAR_MISSING="Λείπει αριστερή παρένθεση \'(\'";
    public static final String RIGHT_BRA_MISSING="Λείπει δεξιά αγκύλη \']\'";
    public static final String LEFT_BRA_MISSING="Λείπει αριστερή αγκύλη \'[\'";
    public static final String QUOTATION_MISSING="Λείπει εισαγωγικό \'";
    public static final String DOUBLE_QUOTATION_MISSING="Λείπουν διπλά εισαγωγικά \"";
    public static final String UNEXPECTED_TERM="Μη ολοκληρώμένη έκφραση. Λέιπει όρος  !";
  

    
}
