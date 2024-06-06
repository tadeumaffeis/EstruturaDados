/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edlld;

/**
 *
 * @author tadeu.maffeis
 */
public class MergeListaLinearDupla {

    ListaLinearDupla lld1;
    ListaLinearDupla lld2;
    ListaLinearDupla lldRes;

    public MergeListaLinearDupla(ListaLinearDupla lld_1, ListaLinearDupla lld_2) {
        this.lld1 = new ListaLinearDupla();
        this.lld2 = new ListaLinearDupla();
        this.lldRes = new ListaLinearDupla();
        
        while (!lld_1.empty()) {
            Node node = lld_1.remove();
            lld1.append(node);
        }
        
        while (!lld_2.empty()) {
            Node node = lld_2.remove();
            lld2.append(node);
        }
    }
    
    public ListaLinearDupla getMergedList()
    {
        //
        // lógica do merge aqui
        //
        return null;
    }
}
