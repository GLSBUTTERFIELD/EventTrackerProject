window.addEventListener('load', function(e) {
	init();
});

function init() {
	loadRecipeList();
	let newRecipeLink = document.getElementById('newRecipe');
	newRecipeLink.addEventListener('click', function(e) {
		loadNewRecipeForm();
	});
	//TODO: event listeners for HTML form buttons, etc.
}

function showAverageRecipeTime(recipes) {
	let totalTimeForAllRecipes = 0;
	if (recipes && Array.isArray(recipes))
		for (let recipe of recipes) {
			if (!isNaN(recipe.totalTime)) {
				totalTimeForAllRecipes += recipe.totalTime;
			}
		}
	let averageTime = Math.round(totalTimeForAllRecipes / recipes.length);
	let timeDiv = document.getElementById('averageTime');
	timeDiv.textContent = 'Average Recipe Time: ' + averageTime + ' minutes';
}

function loadNewRecipeForm() {
	let recipeDiv = document.getElementById('recipeDetailsDiv');
	let listDiv = document.getElementById('recipeListDiv');
	let addDiv = document.getElementById('addRecipeDiv');
	recipeDiv.style.display = 'none';
	listDiv.style.display = 'none';
	let form = document.createElement('form');
	form.name = 'addRecipeForm';

	addDiv.appendChild(form);
	let div = document.createElement('div');
	form.appendChild(div);
	let label = document.createElement('label');
	label.for = 'title';
	label.textContent = 'Recipe Title';
	div.appendChild(label);
	let input = document.createElement('input');
	input.id = 'title';
	input.type = 'text';
	input.name = 'title';
	//input.required = true;
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'description';
	label.textContent = 'Description';
	div.appendChild(label);
	textarea = document.createElement('textarea');
	textarea.id = 'description';
	textarea.name = 'description';
	div.appendChild(textarea);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'directions';
	label.textContent = 'Directions';
	div.appendChild(label);
	textarea = document.createElement('textarea');
	textarea.id = 'directions';
	textarea.name = 'directions';
	textarea.placeholder = 'Do not number each step; instead, add a semi-colon (;) and a space between each new direction.';
	div.appendChild(textarea);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'servings';
	label.textContent = 'Servings';
	div.appendChild(label);
	input = document.createElement('input');
	input.id = 'servings';
	input.type = 'text';
	input.name = 'servings';
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'prepTime';
	label.textContent = 'Prep Time (min)';
	div.appendChild(label);
	input = document.createElement('input');
	input.id = 'prepTime';
	input.type = 'number';
	input.name = 'prepTime';
	input.min = '1';
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'cookTime';
	label.textContent = 'Cook Time (min)';
	div.appendChild(label);
	input = document.createElement('input');
	input.id = 'cookTime';
	input.type = 'number';
	input.name = 'cookTime';
	input.min = '1';
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'source';
	label.textContent = 'Sourced from';
	div.appendChild(label);
	input = document.createElement('input');
	input.id = 'source';
	input.type = 'text';
	input.name = 'source';
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'websiteURL';
	label.textContent = 'Website URL ';
	div.appendChild(label);
	input = document.createElement('input');
	input.id = 'websiteURL';
	input.type = 'text';
	input.name = 'websiteURL';
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'imageURL';
	label.textContent = 'Image URL ';
	div.appendChild(label);
	input = document.createElement('input');
	input.id = 'imageURL';
	input.type = 'text';
	input.name = 'imageURL';
	input.src = 'imageURL';
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'foodType';
	label.textContent = 'Food Type';
	div.appendChild(label);
	let select = document.createElement('select');
	select.id = 'foodType';
	select.name = 'foodType';
	select.required = true;
	div.appendChild(select);
	let option = document.createElement('option');
	option.value = '2';
	option.textContent = 'Korean';
	select.appendChild(option);
	option = document.createElement('option');
	option.value = '3';
	option.textContent = 'Japanese';
	select.appendChild(option);
	option = document.createElement('option');
	option.value = '4';
	option.textContent = 'Italian';
	select.appendChild(option);
	option = document.createElement('option');
	option.value = '5';
	option.textContent = 'Indian';
	select.appendChild(option);
	option = document.createElement('option');
	option.value = '6';
	option.textContent = 'American';
	select.appendChild(option);
	option = document.createElement('option');
	option.value = '7';
	option.textContent = 'Vietnamese';
	select.appendChild(option);

	div = document.createElement('div');
	div.textContent = 'Category(ies)';
	form.appendChild(div);

	label = document.createElement('label');
	label.textContent = 'Breakfast';
	label.for = 'category1';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category1';
	input.value = '1';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category2';
	label.textContent = 'Lunch';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category2';
	input.value = '2';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category3';
	label.textContent = 'Dinner';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category3';
	input.value = '3';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category4';
	label.textContent = 'Dessert';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category4';
	input.value = '4';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category5';
	label.textContent = 'Snack';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category5';
	input.value = '5';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category6';
	label.textContent = 'Vegetarian';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category6';
	input.value = '6';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category7';
	label.textContent = 'Gluten Free';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category7';
	input.value = '7';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category8';
	label.textContent = 'Quick';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category8';
	input.value = '8';
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	input = document.createElement('input');
	input.type = 'submit';
	input.value = 'Submit';
	div.appendChild(input);
	input.addEventListener('click', function(e) {
		e.preventDefault();
		let newRecipe = {
			title: addRecipeForm.title.value,
			description: addRecipeForm.description.value,
			servings: addRecipeForm.servings.value,
			prepTime: addRecipeForm.prepTime.value,
			cookTime: addRecipeForm.cookTime.value,
			directions: addRecipeForm.directions.value,
			source: addRecipeForm.source.value,
			websiteURL: addRecipeForm.websiteURL.value,
			imageURL:
				//			if (addRecipeForm.imageURL.value === '') {
				//				imageURL.src ='images/default.png';
				//				
				//			},
				//			
				addRecipeForm.imageURL.value,
			//input.src = 'imageURL';
			//	if (input.textContent === null || input.textContent === undefined) {
			//		input.src = 'images/default.png';
			//		input.alt = '[No image available]';
			//	}
			//	else {
			//		input.alt = 'Image of ' + recipe.title;
			//		input.src = 'imageURL';
			//	}
			foodType: {
				id: addRecipeForm.foodType.value,
				name: addRecipeForm.foodType.textContent,
			},
			//categories: {
			//addRecipeForm.categories.value,
			//	},
		};

		addNewRecipe(newRecipe);
		addRecipeForm.reset();
	});
}

function addNewRecipe(newRecipe) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/recipes');
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let recipe = JSON.parse(xhr.responseText);
				getRecipe(recipe.id);
			}
		}
		else {
			console.error(xhr.status + ': ' + xhr.responseText);
		}
	};

	let newRecipeJson = JSON.stringify(newRecipe);
	xhr.send(newRecipeJson);
};

function loadRecipeList() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/recipes');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let recipes = JSON.parse(xhr.responseText);
				displayRecipeList(recipes);
				showAverageRecipeTime(recipes);
			}
		}
		else {
			console.error(xhr.status + ': ' + xhr.responseText);
		}
	};
	xhr.send();
}

function displayRecipeList(recipes) {
	let recipeDiv = document.getElementById('recipeDetailsDiv');
	recipeDiv.style.display = 'none';
	if (recipes && Array.isArray(recipes)) {
		let tbody = document.getElementById('recipeListTbody');
		tbody.textContent = '';
		for (let recipe of recipes) {
			let tr = document.createElement('tr');
			tbody.appendChild(tr);
			let td = document.createElement('td');
			let strong = document.createElement('strong');
			td.appendChild(strong);
			strong.textContent = recipe.title;
			let br = document.createElement('br');
			td.appendChild(br);
			let img = document.createElement('img');
			img.recipeId = recipe.id;
			img.classList.add('recipe-thumbnail-img');
			if (recipe.imageURL === null) {
				img.src = 'images/default.png';
				img.alt = '[No image available]';
			}
			else {
				img.alt = 'Image of ' + recipe.title;
				img.src = recipe.imageURL;
			}
			td.addEventListener('click', function(e) {
				getRecipe(e.target.parentElement.parentElement.recipeId);
			})

			td.appendChild(img);
			tr.appendChild(td);

			td = document.createElement('td');
			td.textContent = recipe.description;
			tr.appendChild(td);

			td = document.createElement('td');
			td.textContent = recipe.prepTime + ' minutes';
			tr.appendChild(td);

			td = document.createElement('td');
			td.textContent = recipe.cookTime + ' minutes';
			tr.appendChild(td);

			td = document.createElement('td');
			td.textContent = recipe.totalTime + ' minutes';
			tr.appendChild(td);

			tr.recipeId = recipe.id;
			tr.addEventListener('click', function(e) {
				getRecipe(e.target.parentElement.recipeId);
			});
			tbody.appendChild(tr);
		}
	}
}

function getRecipe(recipeId) {
	let xhr = new XMLHttpRequest();
	console.log(recipeId);
	xhr.open('GET', `api/recipes/${recipeId}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				displayRecipe(JSON.parse(xhr.responseText));
			}
		}
		else {
			console.error(xhr.status + ': ' + xhr.responseText);
		}
	};
	xhr.send();
}

function displayRecipe(recipe) {
	showDetails();
	let recipeDiv = document.getElementById('recipeDetailsDiv');

	let h1 = document.createElement('h1');
	h1.textContent = recipe.title;
	recipeDiv.appendChild(h1);

	let hr = document.createElement('hr');
	recipeDiv.appendChild(hr);

	let p = document.createElement('p');
	p.textContent = recipe.description;
	recipeDiv.appendChild(p);

	let table = document.createElement('table');
	//CLASS TAG	
	table.classList.add('time-servings-table');
	recipeDiv.appendChild(table);
	let tbody = document.createElement('tbody');
	table.appendChild(tbody);
	let tr = document.createElement('tr');
	tbody.appendChild(tr);
	let td = document.createElement('td');
	td.textContent = 'Prep Time: ' + recipe.prepTime + ' minutes';
	tr.appendChild(td);
	td = document.createElement('td');
	td.textContent = 'Cook Time: ' + recipe.cookTime + ' minutes';
	tr.appendChild(td);
	tr = document.createElement('tr');
	tbody.appendChild(tr);
	td = document.createElement('td');
	td.textContent = 'Total Time: ' + recipe.totalTime + ' minutes';
	tr.appendChild(td);
	td = document.createElement('td');
	td.textContent = 'Serves ' + recipe.servings;
	tr.appendChild(td);

	let img = document.createElement('img');
	if (recipe.imageURL === null) {
		img.src = 'images/default.png';
		img.alt = '[No image available]';
	}
	else {
		img.alt = 'Image of ' + recipe.title;
		img.src = recipe.imageURL;
	}
	//CLASS TAG
	img.classList.add('recipe-view-img');
	recipeDiv.appendChild(img);
	hr = document.createElement('hr');
	recipeDiv.appendChild(hr);

	showIngredients(recipe.recipeIngredients, recipeDiv);
	showDirections(recipe.directions, recipeDiv);
	let button = document.createElement('button');
	button.type = 'button';
	button.name = 'editRecipe';
	button.textContent = 'Edit Recipe';
	recipeDiv.appendChild(button);
	button.addEventListener('click', function(e) {
		e.preventDefault();
		loadEditRecipeForm(recipe);
	});
	button = document.createElement('button');
	button.type = 'button';
	button.name = 'deleteRecipe';
	button.textContent = 'Delete Recipe';
	recipeDiv.appendChild(button);
	button.addEventListener('click', function(e) {
		e.preventDefault();
		if (window.confirm("Delete recipe?")) {
			deleteRecipe(recipe.id);
		}
	});
	getReviewsByRecipeId(recipe.id, recipeDiv);
}

function loadEditRecipeForm(recipe) {
	let recipeDiv = document.getElementById('recipeDetailsDiv');
	let listDiv = document.getElementById('recipeListDiv');
	let addDiv = document.getElementById('addRecipeDiv');
	let editDiv = document.getElementById('editRecipeDiv');
	recipeDiv.style.display = 'none';
	listDiv.style.display = 'none';
	addDiv.style.display = 'none';
	editDiv.style.display = 'block';

	let form = document.createElement('form');
	form.name = 'editRecipeForm';
	editDiv.appendChild(form);
	let div = document.createElement('div');
	form.appendChild(div);
	let label = document.createElement('label');
	label.for = 'title';
	label.textContent = 'Recipe Title';
	div.appendChild(label);
	let input = document.createElement('input');
	input.id = 'title';
	input.type = 'text';
	input.name = 'title';
	input.value = recipe.title;
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'description';
	label.textContent = 'Description';
	div.appendChild(label);
	textarea = document.createElement('textarea');
	textarea.id = 'description';
	textarea.name = 'description';
	textarea.value = recipe.description;
	div.appendChild(textarea);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'directions';
	label.textContent = 'Directions. Do not number each step; instead, add a semi-colon (;) and a space between each new direction.';
	div.appendChild(label);
	textarea = document.createElement('textarea');
	textarea.id = 'directions';
	textarea.name = 'directions';
	textarea.value = recipe.directions;
	div.appendChild(textarea);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'servings';
	label.textContent = 'Servings';
	div.appendChild(label);
	input = document.createElement('input');
	input.id = 'servings';
	input.type = 'text';
	input.name = 'servings';
	input.value = recipe.servings;
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'prepTime';
	label.textContent = 'Prep Time (min)';
	div.appendChild(label);
	input = document.createElement('input');
	input.id = 'prepTime';
	input.type = 'number';
	input.name = 'prepTime';
	input.min = '1';
	input.value = recipe.prepTime;
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'cookTime';
	label.textContent = 'Cook Time (min)';
	div.appendChild(label);
	input = document.createElement('input');
	input.id = 'cookTime';
	input.type = 'number';
	input.name = 'cookTime';
	input.min = '1';
	input.value = recipe.cookTime;
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'source';
	label.textContent = 'Sourced from';
	div.appendChild(label);
	input = document.createElement('input');
	input.id = 'source';
	input.type = 'text';
	input.name = 'source';
	input.value = recipe.source;
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'websiteURL';
	label.textContent = 'Website URL ';
	div.appendChild(label);
	input = document.createElement('input');
	input.id = 'websiteURL';
	input.type = 'text';
	input.name = 'websiteURL';
	input.value = recipe.websiteURL;
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'imageURL';
	label.textContent = 'Image URL ';
	div.appendChild(label);
	input = document.createElement('input');
	input.id = 'imageURL';
	input.type = 'text';
	input.name = 'imageURL';
	input.src = 'imageURL';
	input.value = recipe.imageURL;
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	label = document.createElement('label');
	label.for = 'foodType';
	label.textContent = 'Food Type';
	div.appendChild(label);
	let select = document.createElement('select');
	select.id = 'foodType';
	select.name = 'foodType';
	select.required = true;
	div.appendChild(select);
	let option = document.createElement('option');
	option.value = '2';
	option.textContent = 'Korean';
	select.appendChild(option);
	option = document.createElement('option');
	option.value = '3';
	option.textContent = 'Japanese';
	select.appendChild(option);
	option = document.createElement('option');
	option.value = '4';
	option.textContent = 'Italian';
	select.appendChild(option);
	option = document.createElement('option');
	option.value = '5';
	option.textContent = 'Indian';
	select.appendChild(option);
	option = document.createElement('option');
	option.value = '6';
	option.textContent = 'American';
	select.appendChild(option);
	option = document.createElement('option');
	option.value = '7';
	option.textContent = 'Vietnamese';
	select.appendChild(option);

	div = document.createElement('div');
	div.textContent = 'Category(ies)';
	form.appendChild(div);

	label = document.createElement('label');
	label.textContent = 'Breakfast';
	label.for = 'category1';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category1';
	input.value = '1';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category2';
	label.textContent = 'Lunch';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category2';
	input.value = '2';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category3';
	label.textContent = 'Dinner';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category3';
	input.value = '3';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category4';
	label.textContent = 'Dessert';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category4';
	input.value = '4';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category5';
	label.textContent = 'Snack';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category5';
	input.value = '5';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category6';
	label.textContent = 'Vegetarian';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category6';
	input.value = '6';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category7';
	label.textContent = 'Gluten Free';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category7';
	input.value = '7';
	div.appendChild(input);

	label = document.createElement('label');
	label.for = 'category8';
	label.textContent = 'Quick';
	div.appendChild(label);
	input = document.createElement('input');
	input.type = 'checkbox';
	input.id = 'category8';
	input.value = '8';
	div.appendChild(input);

	div = document.createElement('div');
	form.appendChild(div);
	input = document.createElement('input');
	input.type = 'submit';
	input.value = 'Submit';
	div.appendChild(input);
	input.addEventListener('click', function(e) {
		e.preventDefault();
		let updatedRecipe = {
			id:recipe.id,
			title: editRecipeForm.title.value,
			description: editRecipeForm.description.value,
			servings: editRecipeForm.servings.value,
			prepTime: editRecipeForm.prepTime.value,
			cookTime: editRecipeForm.cookTime.value,
			directions: editRecipeForm.directions.value,
			source: editRecipeForm.source.value,
			websiteURL: editRecipeForm.websiteURL.value,
			imageURL: editRecipeForm.imageURL.value,
			foodType: {
				id: editRecipeForm.foodType.value,
				name: editRecipeForm.foodType.textContent,
			},
		};
		updateRecipe(updatedRecipe);
		editRecipeForm.reset();
	});
}

function updateRecipe(updatedRecipe) {
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', `api/recipes/${updatedRecipe.id}`);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.onreadystatechange = function(response) {
		console.log('response is ', response)
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let recipe = JSON.parse(xhr.responseText);
				console.log('recipe from xhr response text', recipe)
				getRecipe(recipe.id);
			}
		}
		else {
			console.error(xhr.status + ': ' + xhr.responseText);
		}
	};
	let updatedRecipeJson = JSON.stringify(updatedRecipe);
	xhr.send(updatedRecipeJson);
};

function deleteRecipe(recipeId) {
	let xhr = new XMLHttpRequest();
	xhr.open('DELETE', `api/recipes/${recipeId}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 204 || xhr.status === 200) {
				console.log('loading recipe list after delete');
				window.location.href="";
			}
		}
		else {
			console.error(xhr.status + ': ' + xhr.responseText);
		}
	}
	xhr.send();
};

function displayError(message) {
	let div = document.getElementById('recipeDetailsDiv');
	div.textContent = '';
	let errMsg = document.createElement('h2');
	errMsg.textContent = message;
	div.appendChild(errMsg);
}

function showDetails() {
	let detailsDiv = document.getElementById('recipeDetailsDiv');
	detailsDiv.textContent = '';
	let listDiv = document.getElementById('recipeListDiv');
	detailsDiv.style.display = 'block';
	listDiv.style.display = 'none';
}
function showList() {
	let detailsDiv = document.getElementById('recipeDetailsDiv');
	let listDiv = document.getElementById('recipeListDiv');
	detailsDiv.style.display = 'none';
	listDiv.style.display = 'block';
}

function showDirections(directions, recipeDiv) {
	let h2 = document.createElement('h2');
	h2.textContent = 'Directions';
	recipeDiv.appendChild(h2);
	let directionsArray = directions.split("; ");
	let ol = document.createElement('ol');
	directionsArray.forEach(function(direction) {
		let li = document.createElement('li');
		li.textContent = direction;
		ol.appendChild(li);
	});
	recipeDiv.appendChild(ol);
}

function showIngredients(ingredientList, recipeDiv) {
	let h2 = document.createElement('h2');
	h2.textContent = 'Ingredients';
	recipeDiv.appendChild(h2);
	let ul = document.createElement('ul');
	//CLASS TAG
	ul.classList.add('ingredients-list');
	recipeDiv.appendChild(ul);
	for (let recipeIngredient of ingredientList) {
		let li = document.createElement('li');
		li.textContent = recipeIngredient.quantityAmount + ' ';
		li.textContent += recipeIngredient.quantityUnit !== null ? ' ' + recipeIngredient.quantityUnit + ' ' : ' ';
		li.textContent += recipeIngredient.ingredient.name;
		li.textContent += recipeIngredient.notes !== null ? ' (' + recipeIngredient.notes + ')' : '';
		ul.appendChild(li);
	}
	recipeDiv.appendChild(ul);
}

function getReviewsByRecipeId(recipeId) {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', `api/recipes/${recipeId}/reviews`);
	xhr.onreadystatechange = function() {
		let recipeDiv = document.getElementById('recipeDetailsDiv')
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let reviews = JSON.parse(xhr.responseText);
				showReviews(reviews, recipeDiv);
			}
		}
		else {
			console.error(xhr.status + ': ' + xhr.responseText);
		}
	};
	xhr.send();
}

function showReviews(reviewList, recipeDiv) {
	let h2 = document.createElement('h2');
	h2.textContent = "Reviews";
	recipeDiv.appendChild(h2);

	for (let review of reviewList) {
		let table = document.createElement('table');
		table.classList.add('review-table');
		recipeDiv.appendChild(table);
		let thead = document.createElement('thead');
		table.appendChild(thead);
		let tr = document.createElement('tr');
		thead.appendChild(tr);
		let th = document.createElement('th');
		th.classList.add('review-table-header');
		th.colspan = "0";
		th.textContent = review.title;
		tr.appendChild(th);

		let tbody = document.createElement('tbody');
		table.appendChild(tbody);
		tr = document.createElement('tr');
		tbody.appendChild(tr);
		let td = document.createElement('td');
		td.textContent = 'Rating: ' + review.rating + '/10';
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = 'Difficulty: ' + review.difficulty;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = 'Cooked ' + review.dateCooked;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = 'Last updated: ' + review.lastUpdate;
		tr.appendChild(td);

		let p = document.createElement('p');
		p.classList.add('review-table-remarks');
		p.textContent = review.remarks;
		table.appendChild(p);

		p = document.createElement('p');
		p.classList.add('review-table-notes');
		p.textContent = 'Notes for the future: ' + review.notesForFuture;
		table.appendChild(p);

		let br = document.createElement('br');
		recipeDiv.appendChild(br);
	};

}

