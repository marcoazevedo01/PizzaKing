<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="modal-cliente" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">   
                <h2 id="label-modal-client" class="col-md-12 container">Cadastro de Cliente</h2>
            </div>
            <div class="modal-body">
                <div class="container col-lg-12 col-md-9 col-sm-9">
                    <form id="form-client" class="form-group-lg" action="CadastrarCliente" method="POST">

                        <div class="form-group">  
                            <input value="${cliente.id}" type="hidden" name="id"/>
                            <label for="nome">Nome:</label>
                            <input value="${cliente.nome}" type="text" class="form-control"  name="nome" required="true"/><br>
                        </div>
                        <div class="form-group">     
                            <label for="email">Email:</label>
                            <input value="${cliente.email}" type="email" class="form-control"  name="email" required="true"/><br>
                        </div>   
                        <div class="form-group">  
                            <label for="senha">Senha:</label>
                            <input value="${cliente.senha}" type="password"  class="form-control"  name="senha" required="true"/><br>
                        </div>  
                        <div class="form-group">   
                            <label for="telefone">Telefone:</label>
                            <input value="${cliente.telefone}" type="text" class="form-control"  name="telefone" id="telefone" required="true"/><br>
                        </div>  
                        <div class="form-group">   
                            <label for="telefone">Cpf:</label>
                            <input value="${cliente.cpf}" type="text" class="form-control"  name="cpf" id="cpf" onblur="TestaCPF(this)" required="true"/><br>
                        </div>  
                </div>  
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                    <input type="submit" id="btn-modal-salvar" class="btn btn-success" value="Salvar"/>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    let btn = document.getElementById('btn-modal-salvar');
    function TestaCPF(strCPF) {
        var elem = strCPF;
        strCPF = strCPF.value.replace(/\D/g, '');
        var Soma;
        var Resto;
        Soma = 0;
        if (strCPF == "00000000000")
            return stop(elem)

        for (i = 1; i <= 9; i++)
            Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
        Resto = (Soma * 10) % 11;

        if ((Resto == 10) || (Resto == 11))
            Resto = 0;
        if (Resto != parseInt(strCPF.substring(9, 10)))
            return stop(elem)

        Soma = 0;
        for (i = 1; i <= 10; i++)
            Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
        Resto = (Soma * 10) % 11;

        if ((Resto == 10) || (Resto == 11))
            Resto = 0;
        if (Resto != parseInt(strCPF.substring(10, 11)))
            return stop(elem)
        return proceed()
    }

    function stop(elem) {      
        $("#cpf").next("label").attr('data-error', 'cpf');
        $("#cpf").addClass("bg-danger");
        btn.disabled = true;
        elem.focus();
    }
    
    function proceed(){
        $("#cpf").removeClass("bg-danger");
         btn.disabled = false;
    }
</script>






