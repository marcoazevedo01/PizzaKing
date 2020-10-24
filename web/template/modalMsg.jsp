<c:if test = "${msg != null}">
    <div class="modal fade" id="modal-msg" tabindex="-1" role="dialog" aria-labelledby="modal-msg"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <p id="modal-msg">${msg}</p>
                    <%
                        out.println(request.getAttribute("variable"));
                    %>
                </div>
            </div>
        </div>
    </div>
    <script>$('#modal-msg').modal('show');</script>            
</c:if> 