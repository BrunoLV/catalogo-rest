<h1>Sistema de Cadastro de Revistas</h1>
<br />
<form name="cadastroForm" novalidate ng-submit="salvar()">
	<table>
		<input type="hidden" name="idHidden" ng-model="revista.id" />
		<tr>
			<td>Titulo:</td>
			<td><input name="titulo" type="text"
				ng-class="{error:cadastroForm.titulo.$dirty && cadastroForm.titulo.$invalid}"
				ng-model="revista.titulo" ng-minlength=3 required ng-focus /></td>
			<td><small class="errorMessage"
				ng-show="cadastroForm.titulo.$dirty && cadastroForm.titulo.$invalid && !cadastroForm.titulo.$focused">
					Valor invalido. </small></td>
		</tr>
		<tr>
			<td>Subtitulo:</td>
			<td><input name="subTitulo" type="text"
				ng-class="{error:cadastroForm.subTitulo.$dirty && cadastroForm.subTitulo.$invalid}"
				ng-model="revista.subTitulo" ng-minlength=3 required ng-focus /></td>
			<td><small class="errorMessage"
				ng-show="cadastroForm.subTitulo.$dirty && cadastroForm.subTitulo.$invalid && !cadastroForm.subTitulo.$focused">
					Valor invalido. </small></td>
		</tr>
		<tr>
			<td>Arco:</td>
			<td><input name="arco" type="text" ng-model="revista.arco" /></td>
		</tr>
		<tr>
			<td>Edição:</td>
			<td><input name="edicaoText" type="number"
				ng-class="{error:cadastroForm.edicao.$dirty && cadastroForm.edicao.$invalid}"
				ng-model="revista.edicao" required ng-focus /></td>
			<td><small class="errorMessage"
				ng-show="cadastroForm.edicao.$dirty && cadastroForm.edicao.$invalid && !cadastroForm.edicao.$focused">
					Valor invalido. </small></td>
		</tr>
		<tr>
			<td>Ano:</td>
			<td><input name="anoPublicacao" type="number"
				ng-class="{error:cadastroForm.anoPublicacao.$dirty && cadastroForm.anoPublicacao.$invalid}"
				ng-model="revista.anoPublicacao" required ng-minlength=4 ng-focus /></td>
			<td><small class="errorMessage"
				ng-show="cadastroForm.anoPublicacao.$dirty && cadastroForm.anoPublicacao.$invalid && !cadastroForm.anoPublicacao.$focused">Valor
			 		invalido.</small></td>
		</tr>
		<tr>
			<td>Valor:</td>
			<td><input name="valor" type="number"
				ng-class="{error:cadastroForm.valor.$dirty && cadastroForm.valor.$invalid}"
				ng-model="revista.valor" required ng-focus /></td>
			<td>
			<td><small class="errorMessage"
				ng-show="cadastroForm.valor.$dirty && cadastroForm.valor.$invalid && !cadastroForm.valor.$focused">Valor invalido.</small></td>
		</tr>
	</table>
	<input type="submit" value="Salvar" />
</form>
<br />
<br />

Filtro de resultados:
<input type="text" style="width: 200px;" ng-model="textoFiltro"
	placeholder="Digite o texto para filtragem." />
<br />
<br />
<table>
	<tr>
		<th colspan="9">Revistas cadastradas no sistema.</th>
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
		<td><input type="button" value="Editar"
			ng-click="editar(revistaT)" /></td>
		<td><input type="button" value="Deletar"
			ng-click="deletar(revistaT.id)" /></td>
	</tr>
</table>