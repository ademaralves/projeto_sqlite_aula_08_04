
package br.com.ademar.janelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class JanelaCadastro extends javax.swing.JFrame {

    public JanelaCadastro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoTelefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        botaoCadastro = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        botaoPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NOME");

        jLabel2.setText("EMAIL");

        jLabel3.setText("TELEFONE");

        jLabel4.setText("CÓDIGO");

        botaoCadastro.setText("CADASTRAR");
        botaoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastroActionPerformed(evt);
            }
        });

        botaoSair.setText("SAIR");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        botaoPrincipal.setText("PRINCIPAL");
        botaoPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTelefone)
                            .addComponent(campoEmail)
                            .addComponent(campoNome)
                            .addComponent(campoCodigo)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(botaoPrincipal)
                        .addGap(18, 18, 18)
                        .addComponent(botaoSair)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastro)
                    .addComponent(botaoSair)
                    .addComponent(botaoPrincipal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastroActionPerformed
     
         Connection conexaoBanco = null;
        PreparedStatement executaInstrucao = null;
        String comandoSQL = "INSERT INTO preso (codigo, nome, email, telefone) VALUES (?,?,?,?)";

        try{            
         Class.forName("org.sqlite.JDBC");
         conexaoBanco = DriverManager.getConnection("jdbc:sqlite://lula.db");       
        
        executaInstrucao=conexaoBanco.prepareStatement(comandoSQL);
        
        executaInstrucao.setString(1, campoCodigo.getText());
        executaInstrucao.setString(2, campoNome.getText());
        executaInstrucao.setString(3, campoEmail.getText());
        executaInstrucao.setString(4, campoTelefone.getText());

       executaInstrucao.execute();       
            JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO", "OK", JOptionPane.INFORMATION_MESSAGE);     
            
        } 
        catch (Exception e) {
             JOptionPane.showMessageDialog(null, "ERRO NO SALVAR", "ERRO", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_botaoCadastroActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        
         System.exit(0);


    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPrincipalActionPerformed

  

        // TODO add your handling code here:
    }//GEN-LAST:event_botaoPrincipalActionPerformed

   
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastro;
    private javax.swing.JButton botaoPrincipal;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
