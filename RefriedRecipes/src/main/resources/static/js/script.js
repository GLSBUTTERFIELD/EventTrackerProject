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
				recipes = JSON.parse(xhr.responseText);
				displayRecipeList(recipes);
			}
		}
		else {
			console.error(xhr.status + ': ' + xhr.responseText);
			displayError('Recipe not found');
		}
	};
	xhr.send();
}

function displayRecipeList(recipes) {
	//DOM to build table rows
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
			img.src = recipe.imageURL;
			img.classList.add('recipe-thumbnail-img');
			img.recipeId = recipe.id;
			//img.classList.add('w-25');

			if (recipe.imageURL === null) {
				img.alt = "[No image available]";
			}
			else {
				img.alt = "Image of " + recipe.title;
			}
			//			img.width = 150;
			//			img.height = 150;
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
				console.log(e.target);
				recipeId = e.target.parentElement.recipeId;
				console.log(recipeId);
				getRecipe(recipe);
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
	console.log(recipe);

	let recipeDiv = document.getElementById('recipeDetailsDiv');
	recipeDiv.textContent = '';
	let h1 = document.createElement('h1');
	h1.textContent = recipe.title;
	recipeDiv.appendChild(h1);
	let img = document.createElement('img');
	img.src = recipe.imageURL;
	img.alt = 'Image of ' + recipe.name;
	recipeDiv.appendChild(img);

	let backButton = document.createElement('button');
	backButton.textContent = "Back to list";
	backButton.classList.add('btn', 'btn-primary');
	backButton.addEventListener('click', function(e) {
		showList();
	});
	recipeDiv.appendChild(backButton);
	showDetails();
}

function showDetails() {
	let detailsDiv = document.getElementById('recipeDetailsDiv');
	let listDiv = document.getElementById('recipeListDiv');
	detailsDiv.style.display = 'none';
	listDiv.style.display = 'block';
}

