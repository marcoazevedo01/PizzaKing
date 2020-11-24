<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="modal-bebida" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">         
                <h2 id="label-modal-bebida" class="col-md-12 container">Cadastro de bebidas</h2>         
            </div>
            <div class="modal-body">
                <div class="container col-lg-12 col-md-9 col-sm-9">
                    <form id="form-bebida" class="form-group-lg" method="POST" action="CadastrarBebida">
                        <div class="form-group">
                            <input type="hidden" name="idProduto" value="${bebida.idProduto}"/>
                            <label for="descricao">Descrição:</label>
                            <input value="${bebida.descricao}" type="text" name="descricao" class="form-control" required/>
                        </div>
                        <div class="form-group">
                            <label for="tipo">tipo:</label>
                            <select name="tipo" class="form-control">
                                <option name="tipo" ${bebida.tipo == 'Verveja' ? 'selected' : ''} value="Cerveja">Cerveja</option>
                                <option name="tipo" ${bebida.tipo == 'Vinho' ? 'selected' : ''} value="Vinho">Vinho</option>
                                <option name="tipo" ${bebida.tipo == 'Refrigerante' ? 'selected' : ''} value="Refrigerante">Refrigerante</option>
                                <option name="tipo" ${bebida.tipo == 'Outros' ? 'selected' : ''} value="Outros">Outros</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="data"> Data Validade:</label>
                            <input type="date"  value="${bebida.dataValidade}" name="dataValidade" class="form-control" required/>
                        </div>
                        <div class="form-group">
                            <label for="medida">Medida:</label>
                            <input type="number" value="${bebida.medida}" name="medida" class="form-control" required/>
                        </div>
                        <div class="form-group">
                            <label for="valor">Valor:</label>
                            <input type="number" value="${bebida.valor}" name="valor" class="form-control" required/>
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