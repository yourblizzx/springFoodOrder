<%@include file="../../parts/header.jsp" %>
<style>
    html,
    body {
        height: 100%;
    }

    body {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-align: center;
        align-items: center;
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
    }

    .form-signin {
        width: 100%;
        max-width: 330px;
        padding: 15px;
        margin: auto;
    }

    .form-signin .checkbox {
        font-weight: 400;
    }

    .form-signin .form-control {
        position: relative;
        box-sizing: border-box;
        height: auto;
        padding: 10px;
        font-size: 16px;
    }

    .form-signin .form-control:focus {
        z-index: 2;
    }

    .form-signin input[type="email"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }

    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
</style>
<div class="container-fluid">
    <div class="row">
        <form class="form-signin card card-primary" method="post">
            <h1 class="h3 mb-3 font-weight-normal">Please register</h1>

            <div class="form-group">
                <label for="inputLogin" class="sr-only">Login</label>
                <input type="text" name="login" id="inputLogin" class="form-control" placeholder="Login" required autofocus>
            </div>

            <div class="form-group">
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name="password"  id="inputPassword" class="form-control" placeholder="Password" required>
            </div>

            <div class="form-group">
                <label for="repeatPassword" class="sr-only">Repeat password</label>
                <input type="password" name="repassword"   id="repeatPassword" class="form-control" placeholder="Password" required>
            </div>

            <div class="form-group">
                <label for="name" class="sr-only">Name</label>
                <input type="text" name="name"   id="name" class="form-control" placeholder="Name" required>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <p class="text-muted">
                Already registered<a class="btn btn-link" href="/">Sign in</a>
            </p>


            <div class="form-group">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
            </div>

        </form>
    </div>
</div>
<%@include file="../../parts/footer.jsp" %>