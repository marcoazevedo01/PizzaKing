<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/nav.jsp" />
<jsp:include page="/template/menu.jsp" />

<div class="container col-md-9 pt-3">
    <div class="col-md-12">
        <div class="row">
            <div class="col-9 col-md-9">
                <h1 id="titulo-form">Fornecedores</h1>
            </div>
            <div>
                <button class="btn btn-success" data-toggle="modal" data-target="#modal-fornecedor" >Cadastrar</button>        
            </div>
        </div>
        <div class="container text-center">
            <div class="col-md-12 pt-4 ">
                <form action="ListarFornecedor" method="POST">
                    <div class="input-group ">
                        <select name="tipo" id="tipo" class="form-control col-md-2" >
                            <option value="nome">Nome</option>
                            <option value="cnpj">Cnpj</option>
                        </select>
                        <input type="text" class="form-control" name="pesquisa" value="" placeholder="Digite para pesquisar"/>
                        <input class="btn btn-primary" type="submit" value="Pesquisar"/>
                    </div>
                </form>
            </div>
        </div>
        <div class="table-responsive maxHeightTable pt-5">
            <table class="table table-striped table-bordered">
                <thead>
                    <tr id="table">              
                        <th>Nome</th>
                        <th>Cnpj</th>
                        <th>E-mail</th>
                        <th>Telefone</th>
                        <th>Editar</th>
                        <th>Remover</th>
                    </tr>
                </thead>
                <tbody id="tbody">
                    <c:forEach items="${fornecedores}" var="fornecedor">
                        <tr id="forn_${fornecedor.idPessoa}">            
                            <td>${fornecedor.nome}</td>
                            <td>${fornecedor.cnpj}</td>
                            <td>${fornecedor.email}</td>
                            <td>${fornecedor.telefone}</td>
                            <td>
                                <img src="img/ico/edit.png" onclick="getFornecedor(${fornecedor.idPessoa})" >                              
                            </td>              
                            <td>
                                <img src="img/ico/remove.png" data-ref="${fornecedor.idPessoa}" data-name="${fornecedor.nome}" data-type="excluir" data-toggle="modal" data-target="#modalRemove">
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="/cadastrar-fornecedor.jsp"/>
<jsp:include page="/template/modalRemov.jsp"/>
<jsp:include page="/template/modalMsg.jsp"/>
<script src="js/ajax.js"></script>
<script type="text/javascript">
    document.querySelector('#tbody').addEventListener('click', event => {
        if (event.srcElement.dataset.type === 'excluir') {
            document.querySelector('#p-msg').textContent = 'Desenha realmente excluir o fornecedor: ' + event.srcElement.dataset.name;
            document.querySelector('#a-excluir').setAttribute('data-ref', event.srcElement.dataset.ref);
        }
    })
    document.getElementById('a-excluir').addEventListener('click', event => {
        let id = event.toElement.dataset.ref; 
        ajaxDoc('ExcluirFornecedor?idPessoa=' + id, 'GET')
            .then(msg => {
                document.getElementById('forn_'+id).remove();
                $('#modalRemove').modal('hide');
            })
            .catch(err => alert('Erro ajax', err))  
    });
    if('${msg}' != ''){
        $('#modal-msg').modal('show');
    }   

    function getFornecedor(id) {
        ajaxDoc('CarregarFornecedor?idPessoa=' + id, 'GET')
            .then(msg => {
                let form = document.getElementById('form-forn');
                form.idPessoa.value =  msg.idPessoa;
                form.nome.value =  msg.nome;
                form.cnpj.value =  msg.cnpj;
                form.email.value =  msg.email;
                form.telefone.value =  msg.telefone;
                document.getElementById('label-modal-forn').textContent = 'Alterar Fornecedor';    
                $('#modal-fornecedor').modal('show')
            })
            .catch(err => alert('Erro ajax', err))
    }
</script>
<jsp:include page="/template/footer.jsp" />