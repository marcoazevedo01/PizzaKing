<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="modal-fornecedor" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">              
                <h2 id="label-modal-forn" class="col-md-12 container">Cadastro de Fornecedor</h2>      
            </div>
            <div class="modal-body">
                <div class="container col-lg-6 col-md-9 col-sm-6">
                    <form id="form-forn" class="form-group-lg" method="POST" action="CadastrarFornecedor">
                        <div class="form-group">
                            <input type="hidden" name="idPessoa" value="${fornecedor.idPessoa}"/>
                            <label for="nome">Nome:</label>
                            <input type="text" name="nome" value="${fornecedor.nome}" class="form-control" required/>
                        </div>
                        <div class="form-group">
                            <label for="cnpj">Cnpj:</label>
                            <input type="text" name="cnpj" id="cnpj" value="${fornecedor.cnpj}" class="form-control" required/>
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
                    <input type="submit" class="btn btn-success" value="Salvar" />
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
