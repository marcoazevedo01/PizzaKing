<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="modal-cliente" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">   
                <h2 id="label-modal-client" class="col-md-12 container">Cadastro de Cliente</h2>
            </div>
            <div class="modal-body">
                <div class="container col-lg-6 col-md-9 col-sm-6">
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
                            <input value="${cliente.cpf}" type="text" class="form-control"  name="cpf" id="cpf" required="true"/><br>
                        </div>  
                </div>  
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                    <input type="submit" class="btn btn-success" value="Salvar"/>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>







