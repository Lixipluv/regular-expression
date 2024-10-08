public class TestFormValidator {

    public static void main(String[] args) {
        // Testar nomes
        testarRegex(FormValidator.regexNome, "Nome", 
            new String[]{"Ada Lovelace", "Alan Turing", "Stephen B King"}, 
            new String[]{"1Alan", "Alan turing", "A1an Turing", "Alan", "123"});  // Adicionei '123' como exemplo inválido

        // Testar emails
        testarRegex(FormValidator.regexEmail, "Email", 
            new String[]{"divulga@ufpa.br", "a@a.br", "a@a.com.br"}, 
            new String[]{"@a.com.br", "a@.br", "a@a.com.br1", "A@ufpa.br", "email@domain..com"}); // Adicionado exemplo de domínio inválido

        // Testar senhas
        testarRegex(FormValidator.regexSenha, "Senha", 
            new String[]{"518R2r5e", "F123456A", "1234567T"}, 
            new String[]{"1234567", "F12345678", "abcdefgh", "ABCDEFGH", "Abcdefgh"}); // Exemplo adicionado para senha sem número

        // Testar CPF
        testarRegex(FormValidator.regexCPF, "CPF", 
            new String[]{"123.456.789-09", "000.000.000-00"}, 
            new String[]{"123.456.789-0", "111.111.11-11", "12345678909", "123.456.789.00"}); // Adicionado exemplo sem formatação

        // Testar telefones
        testarRegex(FormValidator.regexTelefone, "Telefone", 
            new String[]{"(91) 99999-9999", "91 999999999"}, 
            new String[]{"(91) 59999-9999", "99 99999-9999", "(94)95555-5555", "(91) 9999-999"}); // Adicionado exemplo com formatação incorreta

        // Testar data e hora
        testarRegex(FormValidator.regexDataHora, "Data e Hora", 
            new String[]{"31/08/2019 20:14:55", "01/01/2020 00:00:00"}, 
            new String[]{"99/99/9999 99:99:99", "9/9/99 99:99:99", "31-08-2019 20:14:55"}); // Exemplo com separadores incorretos

        // Testar números reais
        testarRegex(FormValidator.regexNumeroReal, "Número Real", 
            new String[]{"-25.467", "1", "+1", "0.56", "1234567.1234567"}, 
            new String[]{"1.", "+64,2", "123456789.123456789"}); // Adicionado exemplo de número com dígitos a mais
    }

    // Função de teste para um regex
    public static void testarRegex(String regex, String campo, String[] aceitos, String[] rejeitados) {
        System.out.println("Testando campo: " + campo);
        for (String input : aceitos) {
            if (FormValidator.validar(regex, input)) {
                System.out.println("  Aceito corretamente: " + input);
            } else {
                System.out.println("  Erro - Deve aceitar: " + input);
            }
        }
        for (String input : rejeitados) {
            if (!FormValidator.validar(regex, input)) {
                System.out.println("  Rejeitado corretamente: " + input);
            } else {
                System.out.println("  Erro - Deve rejeitar: " + input);
            }
        }
    }
}
