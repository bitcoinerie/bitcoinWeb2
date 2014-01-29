<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="navbar navbar-default">
    <div class="navbar-header">
        <a class="navbar-brand" href="/"> Rechercher une transaction</a>
    </div>
    <div class="collapse navbar-collapse navbar-ex1-collapse">

        <form action="/search" class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input name="query" type="text" class="form-control" placeholder="Search Transaction by Emitter">
            </div>
        </form>

        <a href="/add" class="btn btn-default navbar-btn navbar-right">
            <span class="glyphicon glyphicon-plus"></span>
        </a>
    </div>
</div>