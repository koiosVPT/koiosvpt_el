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

import java.awt.datatransfer.Transferable;
import java.io.IOException;


import javax.swing.Action;
import org.openide.actions.CopyAction;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.actions.SystemAction;
import org.openide.util.datatransfer.ExTransferable;
import org.openide.util.lookup.Lookups;
/**
 *
 * @author Jrd
 */
public class ProgCompNode extends AbstractNode {

      private ProgComp pc;
      private String mytab = "                 ";


    public ProgCompNode(ProgComp key) {
        super(Children.LEAF, Lookups.fixed( new Object[] {key} ) );
        this.pc = key;
        setIconBaseWithExtension(key.getImage());
        setDisplayName(mytab);//+pc.getTitle());
    }

    @Override
 public boolean canCopy()
 {return true;}

    @Override
    public Transferable drag() throws IOException {
        return pc;
    }

    @Override
    public Transferable clipboardCopy() throws IOException {
    Transferable deflt = super.clipboardCopy();
    ExTransferable enriched = ExTransferable.create(deflt);
    enriched.put(new ExTransferable.Single(ProgComp.PC_DATA_FLAVOR) {
      protected Object getData() {
        return pc;
      }
    });
    return enriched;
  }

  @Override
    public Action[] getActions(boolean popup) {

            return new Action[]{
                     SystemAction.get(CopyAction.class)    };
        }


  
}
