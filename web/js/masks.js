$(document).ready(function () {
    $("#telefone").mask("(00) 00000-0009", {
        translation: {
            'W': {
                pattern: /[X0-9]/
            }
        }
    });

   $("#cnpj").mask("99.999.999/9999-99");

  
});