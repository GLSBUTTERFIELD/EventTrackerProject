console.log('script.js loaded');

window.addEventListener('load', function(e) {
	console.log('Document loaded.');
	init();
});


function init() {
	console.log('In init');
	loadRecipeList();

	//TODO: event listeners for HTML form buttons, etc.
}

function loadRecipeList() {
	//XHR to hit my list API element
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/recipes');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let recipes = JSON.parse(xhr.responseText);
				displayRecipeList(recipes);
			}
		}
		else {
			console.error(xhr.status + ': ' + xhr.responseText);
			//displayError('Recipe not found');
		}
	};
	xhr.send();
}

function displayRecipeList(recipes) {
	//DOM to build table rows
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

function displayError(message) {
	let div = document.getElementById('recipeDetailsDiv');
	div.textContent = '';
	let errMsg = document.createElement('h2');
	errMsg.textContent = message;
	div.appendChild(errMsg);
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
			//displayError('Recipe not found');
		}
	};
	xhr.send();
}


function displayRecipe(recipe) {
	showDetails();
	let recipeDiv = document.getElementById('recipeDetailsDiv');
	let backButton = document.createElement('button');
	backButton.textContent = "Back to list";
	backButton.classList.add('btn', 'btn-primary');

	backButton.addEventListener('click', function(e) {
		loadRecipeList();
		showList();
	});
	recipeDiv.appendChild(backButton);

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
	img.src = recipe.imageURL;
	img.alt = 'Image of ' + recipe.title;
	//CLASS TAG
	img.classList.add('recipe-view-img');
	recipeDiv.appendChild(img);
	hr = document.createElement('hr');
	recipeDiv.appendChild(hr);

	showIngredients(recipe.recipeIngredients, recipeDiv);
	showDirections(recipe.directions, recipeDiv);
	getReviewsByRecipeId(recipe.id, recipeDiv);
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

function showReviews(reviewList, recipeDiv) {
	let h2 = document.createElement('h2');
	h2.textContent = "Reviews";
	recipeDiv.appendChild(h2);

	for (let review of reviewList) {
		let strong = document.createElement('strong');
		strong.textContent = review.title;
		recipeDiv.appendChild(strong);

		let table = document.createElement('table');
		recipeDiv.appendChild(table);
		let tbody = document.createElement('tbody');
		table.appendChild(tbody);
		let tr = document.createElement('tr');
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
		td.textContent = 'Review updated: ' + review.lastUpdate;
		tr.appendChild(td);

		let blockquote = document.createElement('blockquote');
		blockquote.textContent = review.remarks;
		recipeDiv.appendChild(blockquote);

		let p = document.createElement('p');
		p.textContent = review.notesForFuture;
		recipeDiv.appendChild(p);

	};

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
			//displayError('Recipe not found');
		}
	};
	xhr.send();
}






