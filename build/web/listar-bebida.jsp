<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/template/nav.jsp" />
<jsp:include page="/template/menu.jsp" />
        
<div class="container col-md-9 pt-3">
    <div class="col-md-12">
        <div class="row">
            <div class="col-9 col-md-9">
                <h2 id="titulo-form">Bebidas</h2>
            </div>
            <div>
                <button class="btn btn-success" data-toggle="modal" data-target="#modal-bebida" >Cadastrar</button>
            </div>
        </div>
    </div>
    <div class="container text-center">
        <div class="col-md-12 pt-4 ">
            <form action="ListarBebida" method="POST">
                <div class="input-group ">
                    <select name="tipo" id="tipo" class="form-control col-md-2" >                    
                        <option value="nome">Nome</option>
                        <option value="dataValidade">Validade</option>
                    </select>
                    <input type="text" class="form-control"  name="pesquisa" value="" placeholder="Digite para pesquisar"/>
                    <input class="btn btn-primary" type="submit" value="Pesquisar"/>
                </div>
            </form>
        </div>
    </div>
    <div class="table-responsive maxHeightTable pt-5">
        <table class="table table-striped table-bordered">
            <thead>
                <tr id="table">          
                    <th>Descricao</th>
                    <th>Tipo</th>
                    <th>Validade</th>
                    <th>Medida</th>
                    <th>Valor</th>
                    <th>Editar</th>
                    <th>Remover</th>
                </tr>
            </thead>
            <tbody id="tbody">
                <c:forEach items="${bebidas}" var="bebida">
                    <tr>                    
                        <td>${bebida.descricao}</td>
                        <td>${bebida.tipo}</td>
                        <td>${bebida.dataValidade}</td>
                        <td>${bebida.medida}</td>
                        <td>${bebida.valor}</td>
                        <td>                    
                            <img src="img/ico/edit.png" onclick="getBebida(${bebida.idProduto})">
                        </td>  
                        <td> 
                            <img src="img/ico/remove.png" data-ref="${bebida.idProduto}" data-name="${bebida.descricao}" data-type="excluir" data-toggle="modal" data-target="#modalRemove">
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/cadastrar-bebida.jsp"/>
<jsp:include page="/template/modalRemov.jsp"/>
<script src="js/ajax.js"></script>
<script type="text/javascript">
    document.querySelector('#tbody').addEventListener('click', event => {
        if (event.srcElement.dataset.type === 'excluir') {
            document.querySelector('#p-msg').textContent = 'Desenha realmente excluir a bebida: ' + event.srcElement.dataset.name;
            document.querySelector('#a-excluir').href = `ExcluirBebida?idProduto=` + event.srcElement.dataset.ref;
        }
    })
    
     function getBebida(id) {
        ajaxDoc('CarregarBebida?idProduto=' + id, 'GET')
            .then(msg => {
                let form = document.getElementById('form-bebida');
                form.idProduto.value =  msg.idProduto;
                form.descricao.value =  msg.descricao;
                form.tipo.value =  msg.tipo;
                form.dataValidade.value =  msg.dataValidade;
                form.medida.value =  msg.medida;
                form.valor.value =  msg.valor;      
                document.getElementById('label-modal-bebida').textContent = 'Alterar Bebida';    
                $('#modal-bebida').modal('show')
            })
            .catch(err => alert('Erro ajax', err))
    }
</script>
<jsp:include page="/template/footer.jsp" />