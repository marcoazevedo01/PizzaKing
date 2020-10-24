<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="modal-funcionario" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 id="label-modal-func" class="col-md-12 container">Cadastro de Funcionário</h2>
            </div>
            <div class="modal-body">
                <div class="container col-lg-12 col-md-9 col-sm-9">
                    <form id="form-func" class="form-group-lg" action="CadastrarFuncionario" method="POST">
                        <div class="form-group">  
                            <input value="${funcionario.id}" type="hidden" name="id"/>
                            <label for="nome">Nome:</label>
                            <input value="${funcionario.nome}" type="text" class="form-control" name="nome" required/>
                        </div>
                        <div class="form-group">
                            <label for="salario">Salário:</label>
                            <input value="${funcionario.salario}" type="number" class="form-control" name="salario" required/>
                        </div>
                        <div class="form-group">  
                            <label for="telefone">Telefone:</label>
                            <input value="${funcionario.telefone}" type="text"  class="form-control" name="telefone" id="telefone" required/>
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