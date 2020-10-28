<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/template/nav.jsp"/>
<jsp:include page="/template/menu.jsp" />

<div class="container col-md-9 pt-3">
    <div class="col-md-12">
        <div class="row">
            <div class="col-9 col-md-9">
                <h1 id="titulo-form">Funcionários</h1>
            </div>
            <div>
                <button class="btn btn-success" data-toggle="modal" data-target="#modal-funcionario" >Cadastrar</button>  
            </div>
        </div>
    </div>
    <div class="container text-center">
        <div class="col-md-12 pt-4 ">
            <form action="ListarFuncionario" method="POST">
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
    <div class="table-responsive maxHeightTable pt-5">
        <table class="table table-striped table-bordered">
            <thead>
                <tr id="table">                
                    <th>Nome</th>
                    <th>Salário</th>
                    <th>Telefone</th>
                    <th>Editar</th>
                    <th>Remover</th>
                </tr>
            </thead>
            <tbody id="tbody">
                <c:forEach var="funcionario" items="${funcionarios}">
                    <tr id="func_${funcionario.id}">                  
                        <td>${funcionario.nome}</td>
                        <td>${funcionario.salario}</td>
                        <td>${funcionario.telefone}</td>
                        <td> 
                            <img src="img/ico/edit.png" onclick="getFuncionario(${funcionario.id})">
                        </td>
                        <td> 
                            <img src="img/ico/remove.png" data-ref="${funcionario.id}" data-name="${funcionario.nome}" data-type="excluir" data-toggle="modal" data-target="#modalRemove">
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="/template/modalRemov.jsp"/>
<jsp:include page="/cadastrar-funcionario.jsp"/>
<jsp:include page="/template/modalMsg.jsp"/>
<script src="js/ajax.js"></script>
<script type="text/javascript">
    document.querySelector('#tbody').addEventListener('click', event => {
        if (event.srcElement.dataset.type === 'excluir') {
            document.querySelector('#p-msg').textContent = 'Desenha realmente excluir o funcionario: ' + event.srcElement.dataset.name;
            document.querySelector('#a-excluir').setAttribute('data-ref', event.srcElement.dataset.ref);
        }
    })
     document.getElementById('a-excluir').addEventListener('click', event => {
        console.log(event.toElement.dataset.ref);
        let id = event.toElement.dataset.ref; 
        ajaxDoc('ExcluirFuncionario?id=' + id, 'GET')
            .then(msg => {
                document.getElementById('func_'+id).remove();
                $('#modalRemove').modal('hide');
            })
            .catch(err => alert('Erro ajax', err))  
    });
    
    if('${msg}' != ''){
        $('#modal-msg').modal('show');
    }
 
    function getFuncionario(id) {
         ajaxDoc('CarregarFuncionario?id=' + id, 'GET')
            .then(msg => {
                let form = document.getElementById('form-func');
                form.id.value =  msg.id;
                form.nome.value =  msg.nome;
                form.salario.value =  msg.salario;
                form.telefone.value =  msg.telefone;
                document.getElementById('label-modal-func').textContent = 'Alterar Funcionario';     
                $('#modal-funcionario').modal('show')
            })
            .catch(err => alert('Erro ajax', err))
    }
</script>
<jsp:include page="/template/footer.jsp"/>

