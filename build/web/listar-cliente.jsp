<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/template/nav.jsp"/>
<jsp:include page="/template/menu.jsp" />

<div class="container col-md-9 pt-3">
    <div class="col-md-12">
        <div class="row">
            <div class="col-8 col-md-9">
                <h2 id="titulo-form">Clientes</h2>
            </div>
            <div>  
                <button class="btn btn-success" data-toggle="modal" data-target="#modal-cliente" >Cadastrar</button>                    
            </div>
        </div>
    </div>
    <div class="container col-md-12 text-center">
        <div class="col-md-12 pt-4 ">
            <form action="ListarCliente" method="POST">
                <div class="input-group ">
                    <select name="tipo" id="tipo" class="form-control col-md-2" >
                        <option value="nome">Nome</option>
                        <option value="telefone">Telefone</option>
                    </select>
                    <input type="text" class="form-control" name="pesquisa" value="" placeholder="Digite para pesquisar"/>
                    <input class="btn btn-primary" type="submit" value="Pesquisar"/>
                </div>
            </form>
        </div>
    </div>
    <div class="table-responsive maxHeightTable pt-3">
        <table class="table table-striped table-bordered">
            <thead>
                <tr id="table">               
                    <th>Nome</th>
                    <th>Email</th>             
                    <th>Telefone</th>
                    <th>Cpf</th>
                    <th>Editar</th>
                    <th>Remover</th>
                </tr>
            </thead>
            <tbody id="tbody">
                <c:forEach var="cliente" items="${clientes}" >
                    <tr id="cliente_${cliente.id}">
                        <td>${cliente.nome}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.telefone}</td>
                        <td>${cliente.cpf}</td>
                        <td>
                            <img src="img/ico/edit.png" onclick="getCliente(${cliente.id})">
                        </td>
                        <td> 
                            <img src="img/ico/remove.png" data-ref="${cliente.id}" data-name="${cliente.nome}" data-type="excluir" data-toggle="modal" data-target="#modalRemove">                  
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="/cadastrar-cliente.jsp"/>
<jsp:include page="/template/modalRemov.jsp"/>
<jsp:include page="/template/modalMsg.jsp"/>
<script src="js/ajax.js"></script>
<script type="text/javascript">
    document.querySelector('#tbody').addEventListener('click', event => {
        if (event.srcElement.dataset.type === 'excluir') {
            document.querySelector('#p-msg').textContent = 'Desenha realmente excluir o cliente: ' + event.srcElement.dataset.name;
            document.querySelector('#a-excluir').setAttribute('data-ref', event.srcElement.dataset.ref);
        }
    })
    document.getElementById('a-excluir').addEventListener('click', event => {
        let id = event.toElement.dataset.ref; 
        ajaxDoc('ExcluirCliente?id=' + id, 'GET')
            .then(msg => {
                document.getElementById('cliente_'+id).remove();
                $('#modalRemove').modal('hide');
            })
            .catch(err => alert('Erro ajax', err))  
    });
    
    if('${msg}' != ''){
        $('#modal-msg').modal('show');
    }
    
    function getCliente(id) {
        ajaxDoc('CarregarCliente?id=' + id, 'GET')
            .then(msg => {
                let form = document.getElementById('form-client');
                form.id.value =  msg.id;
                form.nome.value =  msg.nome;
                form.email.value =  msg.email;
                form.senha.value =  msg.senha;
                form.telefone.value =  msg.telefone;
                form.cpf.value =  msg.cpf;
                document.getElementById('label-modal-client').textContent = 'Alterar Cliente';    
                $('#modal-cliente').modal('show')
            })
            .catch(err => alert('Erro ajax', err))
    }
</script>
<jsp:include page="/template/footer.jsp"/>

