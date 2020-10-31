<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="modal-fornecedor" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">              
                <h2 id="label-modal-forn" class="col-md-12 container">Cadastro de Fornecedor</h2>      
            </div>
            <div class="modal-body">
                <div class="container col-lg-6 col-md-9 col-sm-6">
                    <form id="form-fornecedor" class="form-group-lg" method="POST" action="CadastrarFornecedor">
                        <div class="form-group">
                            <input type="hidden" name="idPessoa" value="${fornecedor.idPessoa}"/>
                            <label for="nome">Nome:</label>
                            <input type="text" name="nome" value="${fornecedor.nome}" class="form-control" required/>
                        </div>
                        <div class="form-group">
                            <label for="cnpj">Cnpj:</label>
                            <input type="text" name="cnpj" id="cnpj" value="${fornecedor.cnpj}" onblur="TestaCNPJ(this)" class="form-control" required/>
                        </div>
                        <div class="form-group">
                            <label for="email">E-mail:</label>
                            <input type="email" name="email" value="${fornecedor.email}" class="form-control" required/>
                        </div>
                        <div class="form-group">
                            <label for="telefone">Telefone:</label>
                            <input type="text" name="telefone" value="${fornecedor.telefone}" class="form-control" id="telefone" required/>
                        </div>
                </div> 
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                    <input type="submit" id="btn-modal-salvar" class="btn btn-success" value="Salvar" />
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    let btn = document.getElementById('btn-modal-salvar');
    function TestaCNPJ(cnpj) {
        var elem = cnpj;
        cnpj = cnpj.value.replace(/[^\d]+/g, '');

        if (cnpj == '')
            return stop(elem);

        if (cnpj.length != 14)
            return stop(elem);

        // Elimina CNPJs invalidos conhecidos
        if (cnpj == "00000000000000" ||
                cnpj == "11111111111111" ||
                cnpj == "22222222222222" ||
                cnpj == "33333333333333" ||
                cnpj == "44444444444444" ||
                cnpj == "55555555555555" ||
                cnpj == "66666666666666" ||
                cnpj == "77777777777777" ||
                cnpj == "88888888888888" ||
                cnpj == "99999999999999")
            return stop(elem);

        // Valida DVs
        tamanho = cnpj.length - 2
        numeros = cnpj.substring(0, tamanho);
        digitos = cnpj.substring(tamanho);
        soma = 0;
        pos = tamanho - 7;
        for (i = tamanho; i >= 1; i--) {
            soma += numeros.charAt(tamanho - i) * pos--;
            if (pos < 2)
                pos = 9;
        }
        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
        if (resultado != digitos.charAt(0))
            return stop(elem);

        tamanho = tamanho + 1;
        numeros = cnpj.substring(0, tamanho);
        soma = 0;
        pos = tamanho - 7;
        for (i = tamanho; i >= 1; i--) {
            soma += numeros.charAt(tamanho - i) * pos--;
            if (pos < 2)
                pos = 9;
        }
        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
        if (resultado != digitos.charAt(1))
            return stop(elem);

        return proceed();

    }
    
    function stop(elem) {      
        $("#cnpj").next("label").attr('data-error', 'cpf');
        $("#cnpj").addClass("bg-danger");
        btn.disabled = true;
        elem.focus();
    }
    
    function proceed(){
        $("#cnpj").removeClass("bg-danger");
         btn.disabled = false;
    }
</script>                        
