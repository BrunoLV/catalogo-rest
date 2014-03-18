<h1>Sistema de Cadastro de Revistas</h1>
<br />
<form name="cadastroForm" class="form-horizontal" role="form" novalidate ng-submit="salvar()">
	<input type="hidden" name="idHidden" ng-model="revista.id" />
	<fieldset>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="titulo">Título:</label>
			<div class="col-sm-10">
				<input id="titulo" name="titulo" type="text" class="form-control" style="width: 70%;" ng-model="revista.titulo" ng-minlength=3 required ng-focus />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="subtitulo">Subtítulo:</label>
			<div class="col-sm-10">
				<input id="subTitulo" name="subTitulo" type="text" class="form-control" style="width: 70%;" ng-model="revista.subTitulo" ng-minlength=3 required ng-focus />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="arco">Arco:</label>
			<div class="col-sm-10">
				<input id="arco" name="arco" type="text" class="form-control" style="width: 70%;" ng-model="revista.arco" ng-minlength=3 ng-focus />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="edicaoText">Edição:</label>
			<div class="col-sm-10">
				<input id="edicaoText" name="edicaoText" type="number" class="form-control" style="width: 20%;" ng-model="revista.edicao" required ng-focus />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="anoPublicacao">Ano:</label>
			<div class="col-sm-10">
				<input id="anoPublicacao" name="anoPublicacao" type="number" class="form-control" style="width: 20%;" ng-model="revista.anoPublicacao" ng-minlength=4 required ng-focus />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="valor">Valor:</label>
			<div class="col-sm-10">
				<input id="valor" name="valor" type="number" class="form-control" style="width: 20%;" ng-model="revista.valor" required ng-focus />
			</div>
		</div>
		<input class="btn btn-primary" type="submit" value="Salvar" />
	</fieldset>
</form>
<br />
<br />
<label class="control-label" for="textoFiltro">Filtro:</label>
<input id="textoFiltro" name="textoFiltro" type="text" class="form-control" style="width: 50%;" ng-model="textoFiltro" placeholder="Digite o texto para filtragem." />
<br />
<br />
<div class="table-responsive">
<table class="table table-bordered">
	<tr>
		<th colspan="9" style="text-align: center;">Revistas cadastradas no sistema.</th>
	</tr>
	<tr>
		<th>Id</th>
		<th>Titulo</th>
		<th>SubTitulo</th>
		<th>Arco</th>
		<th>Edicao</th>
		<th>Ano</th>
		<th>Valor</th>
	</tr>
	<tr ng-repeat="revistaT in revistas | filter:textoFiltro">
		<td>{{revistaT.id}}</td>
		<td>{{revistaT.titulo}}</td>
		<td>{{revistaT.subTitulo}}</td>
		<td>{{revistaT.arco}}</td>
		<td>{{revistaT.edicao}}</td>
		<td>{{revistaT.anoPublicacao}}</td>
		<td>{{revistaT.valor | currency:'R$'}}</td>
		<td style="text-align: center;"><input class="btn btn-primary" type="button" value="Editar" ng-click="editar(revistaT)" /></td>
		<td style="text-align: center;"><input class="btn btn-primary" type="button" value="Deletar" ng-click="deletar(revistaT.id)" /></td>
	</tr>
</table>
</div>