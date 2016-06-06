
package br.com.hitalo.interfaces;

import br.com.hitalo.connect.DBManager;
import br.com.hitalo.forms.Produto;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import br.com.hitalo.dialogs.AddCarrinho;
import br.com.hitalo.dialogs.FinalizarVenda;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JFrame;


public class PainelVenda extends javax.swing.JPanel {

    private JFrame parent;
    private DBManager dbManager;
    private TableRowSorter<TableModel> rowSorter;
    private BigDecimal valorCompra;
            
    
    public PainelVenda(JFrame parent) {
        initComponents();
        this.parent = parent;
        dbManager = new DBManager();
        valorCompra = new BigDecimal("0.00");
        setSorter();
        
        
        preencherTabelaProdutosBuscados();
    }

    private void preencherTabelaProdutosBuscados() {
        DefaultTableModel model = (DefaultTableModel) tbProdutosBuscados.getModel();
        
        model.setRowCount(0);
        try {
            Iterator<Produto> itProdutos = dbManager.getProdutos().iterator();
            
            Produto produto;
            while(itProdutos.hasNext()) {
                produto = itProdutos.next();
                model.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getMarca(), produto.getUnidade(), produto.getValor()});
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        
    }
    
    private void setSorter() {
        rowSorter = new TableRowSorter<>(tbProdutosBuscados.getModel());
        tbProdutosBuscados.setRowSorter(rowSorter);
        
        tfBuscar.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = tfBuscar.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = tfBuscar.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutosBuscados = new javax.swing.JTable();
        tfBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProdutosCarrinho = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btAdicionarCarrinho = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbMensagem = new javax.swing.JLabel();
        btRemoverCarrinho = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbValorCompra = new javax.swing.JLabel();
        btComprar = new javax.swing.JButton();

        tbProdutosBuscados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Marca", "Unidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbProdutosBuscados);

        tbProdutosCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Marca", "Unidade", "Valor", "Quantidade", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbProdutosCarrinho);

        jLabel1.setText("Carrinho");

        btAdicionarCarrinho.setText("Adicionar");
        btAdicionarCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarCarrinhoActionPerformed(evt);
            }
        });

        jLabel2.setText("Produtos");

        lbMensagem.setForeground(new java.awt.Color(255, 0, 51));

        btRemoverCarrinho.setText("Remover");
        btRemoverCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverCarrinhoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("R$");

        lbValorCompra.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbValorCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbValorCompra.setText("0,0");

        btComprar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btComprar.setText("Comprar");
        btComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAdicionarCarrinho)
                            .addComponent(jLabel2)
                            .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btComprar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btRemoverCarrinho)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                            .addComponent(tfBuscar, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(326, 326, 326))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAdicionarCarrinho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRemoverCarrinho)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(btComprar)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarCarrinhoActionPerformed
        DefaultTableModel modelProdutosBuscados = (DefaultTableModel) tbProdutosBuscados.getModel();
        
        if(tbProdutosBuscados.getSelectedRowCount() == 1) {
            
            
            AddCarrinho addCarrinho = new AddCarrinho(parent, true);
            addCarrinho.setValues(modelProdutosBuscados.getValueAt(tbProdutosBuscados.convertRowIndexToModel(tbProdutosBuscados.getSelectedRow()), 0).toString(),
                    modelProdutosBuscados.getValueAt(tbProdutosBuscados.convertRowIndexToModel(tbProdutosBuscados.getSelectedRow()), 1).toString(), 
                    modelProdutosBuscados.getValueAt(tbProdutosBuscados.convertRowIndexToModel(tbProdutosBuscados.getSelectedRow()), 2).toString(),
                    modelProdutosBuscados.getValueAt(tbProdutosBuscados.convertRowIndexToModel(tbProdutosBuscados.getSelectedRow()), 3).toString(),
                    modelProdutosBuscados.getValueAt(tbProdutosBuscados.convertRowIndexToModel(tbProdutosBuscados.getSelectedRow()), 4).toString());
            ArrayList<String> values = addCarrinho.showDialog();
            adicionarCarrinho(values);
            
            lbMensagem.setText("");
        } else {
            lbMensagem.setText("Nenhum produto selecionado!");
        }
        
        
    }//GEN-LAST:event_btAdicionarCarrinhoActionPerformed

    private void adicionarCarrinho(ArrayList<String> values) {
        
        if(!values.isEmpty()) {
            DefaultTableModel modelProdutosCarrinho = (DefaultTableModel) tbProdutosCarrinho.getModel();
            modelProdutosCarrinho.addRow(new Object[]{values.get(0), values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6)});
            valorCompra = valorCompra.add(new BigDecimal(values.get(6)));
            lbValorCompra.setText(String.valueOf(valorCompra));
        }
        
    }
    
    private void btRemoverCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverCarrinhoActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbProdutosCarrinho.getModel();
        
        if(tbProdutosCarrinho.getSelectedRowCount() == 1) {
            valorCompra =  valorCompra.subtract(new BigDecimal(model.getValueAt(tbProdutosCarrinho.getSelectedRow(), 6).toString()));
            lbValorCompra.setText(String.valueOf(valorCompra));
            model.removeRow(tbProdutosCarrinho.getSelectedRow());
        }
    }//GEN-LAST:event_btRemoverCarrinhoActionPerformed

    private void btComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarActionPerformed
        new FinalizarVenda(parent, true).setVisible(true);
    }//GEN-LAST:event_btComprarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarCarrinho;
    private javax.swing.JButton btComprar;
    private javax.swing.JButton btRemoverCarrinho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMensagem;
    private javax.swing.JLabel lbValorCompra;
    private javax.swing.JTable tbProdutosBuscados;
    private javax.swing.JTable tbProdutosCarrinho;
    private javax.swing.JTextField tfBuscar;
    // End of variables declaration//GEN-END:variables
}
