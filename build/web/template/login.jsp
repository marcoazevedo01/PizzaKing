<link rel="stylesheet" href="css/login.css" />
<div class="modal fade" id="modal-login" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="login">
                <div class="form">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h2>Login</h2>   
                    <p class="text-center alert-danger">${msg}</p>
                    <form id="form-login" action="Logar" method="POST">
                        <div class="form-field">
                            <label for="email"><i class="fa fa-user"></i></label>
                            <input id="email" type="email" name="email" placeholder="E-mail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required>
                            <svg>
                                <use href="#svg-check" />
                            </svg>
                        </div>
                        <div class="form-field">
                            <label for="login-password"><i class="fa fa-lock"></i></label>
                            <input id="login-password" type="password" name="senha" placeholder="Password" pattern=".{6,}" required>
                            <svg>
                                <use href="#svg-check" />
                            </svg>
                        </div>
                        <button type="submit" class="button">
                            <div class="arrow-wrapper">
                                <span class="arrow"></span>
                            </div>
                            <p class="button-text">Entrar</p>
                        </button>
                    </form>
                </div>
                <div class="finished">
                    <svg>
                    <use href="#svg-check" />
                    </svg>
                </div>
            </div>
            <!-- //--- ## SVG SYMBOLS ############# -->
            <svg style="display:none;">
            <symbol id="svg-check" viewBox="0 0 130.2 130.2">
                <polyline points="100.2,40.2 51.5,88.8 29.8,67.5 "/>
            </symbol>
            </svg>
        </div>
    </div>
</div>
<script>
    $('#form-login').on('submit', function () {
        $('.login').addClass('loading').queue(function () {
            $(this).addClass('active')
        });
    });
    
    if('${msg}' != ''){
        $('#modal-login').modal('show');
    }
</script>


