<jsp:include page="/template/nav.jsp"/>
<jsp:include page="/template/menu.jsp" />

<div class="container md-10 p-4">
    <h2>Pedidos</h2>
        <div class="table-responsive maxHeightTable pt-5">
        <table class="table table-striped table-bordered">
            <thead>
                <tr id="table">               
                    <th>Cliente</th>
                    <th>Data</th>
                    <th>Valor</th>
                    <th>Detalhes</th>
                </tr>
            </thead>
            <tbody id="tbody">
                <c:forEach var="cliente" items="${clientes}" >
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>                        
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="/template/footer.jsp" />