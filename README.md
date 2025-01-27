# EventTrackerProject
### Overview
Description of application's premise/purpose, what need it meets

Refried Recipes is a RESTful web service designed to capture recipes and recipe reviews. It allows users to add in recipes they would like to try, then add ratings and notes after they've made and tasted the recipe, allowing them to access recipes in user-friendly ways like searching by ingredient, food type, 

### Description
Users have full or partial Create, Read, Update, and Delete (CRUD) functionality on the following entities:
<ul>
	<li><em>categories:</em> tags for specific kinds of meals, such as breakfast, quick, gluten free, etc. A recipe can have multiple categories.</li>
	<li><em>food types: </em>describes the type of food, such as Korean, Italian, American, etc. A recipe can have one food type.</li>
	<li><em>ingredients:</em> all ingredients in the database with an optional description and image URL.</li>
	</li><li>recipes: title, description, servings, prep and cook time, directions, source, and website and image URLs. Each recipe must have one food type.</li>
	<li><em>recipe ingredients:</em> ingredients (amount and unit) and notes for for a specific recipe.</li> 
	<li><em>reviews:</em> remarks, difficulty level, rating, and notes for the future of each record of making a recipe.
</ul>
Below are the current URL routes tested through postman:
<table class="table table-bordered">
	<thead>
		<td><strong>Route</strong></td>
		<td><strong>Functionality</strong></td>
	</thead>
	<tbody>
		<tr>
			<td>GET api/recipes (or api/recipes/)</td>
			<td>Gets all recipes</td>
		</tr>
		<tr>
			<td>GET api/recipes/{recipeId}</td>
			<td>Gets one recipe by id</td>
		</tr>
		<tr>
			<td>GET api/recipes/{recipeId}/reviews</td>
			<td>Gets all reviews for one recipe by id</td>	
		</tr>
		<tr>
			<td>POST api/recipes</td>
			<td>Creates a new recipe</td>
		</tr>
		<tr>
			<td>PUT api/recipes/{recipeId}</td>
			<td>Replaces an existing recipe by id</td>
		</tr>
		<tr>
			<td>DELETE api/recipes/{recipeId}</td>
			<td>Deletes an existing recipe by id</td>
		</tr>
		<tr>
			<td>GET api/recipes/categories (or api/recipes/categories/)</td>
			<td>Gets all categories</td>
		</tr>
		<tr>
			<td>POST api/recipes/categories</td>
			<td>Creates a new category</td>
		</tr>
		<tr>
			<td>GET api/recipes/foodtypes (or api/recipes/foodtypes/)</td>
			<td>Gets all food types</td>
		</tr>
		<tr>
			<td>POST api/recipes/foodtypes</td>
			<td>Creates a new foodtype</td>
		</tr>
		<tr>
			<td>GET api/ingredients (or api/ingredients/)</td>
			<td>Gets all ingredients</td>
		</tr>
		<tr>
			<td>GET api/ingredients/{ingredientId}</td>
			<td>Gets one ingredient by id</td>
		</tr>
		<tr>
			<td>GET api/ingredients/search/{keyword}</td>
			<td>Gets one ingredient by keyword</td>
		</tr>
		<tr>
			<td>POST api/ingredients</td>
			<td>Creates a new ingredient</td>
		</tr>
		<tr>
			<td>PUT api/ingredients/{ingredientId}</td>
			<td>Replaces an existing ingredient by id</td>
		</tr>
		<tr>
			<td>GET api/recipes/{recipeId}/ingredients</td>
			<td>Gets all recipe ingredients by recipe id</td>
		</tr>
		<tr>
			<td>POST api/recipes/{recipeId}/ingredients</td>
			<td>Creates a new recipe ingredient/adds to recipe by id</td>
		</tr>
		<tr>
			<td>PUT api/recipes/{recipeId}/ingredients/{ingredientId}</td>
			<td>Replaces an existing recipe ingredient by recipe id and ingredient id</td>
		</tr>
		<tr>
			<td>DELETE api/recipes/{recipeId}/ingredients/{ingredientId}</td>
			<td>Deletes an existing recipe by recipe id and ingredient id</td>
		</tr>
		<tr>
			<td>GET api/recipes/reviews</td>
			<td>Gets all reviews</td>
		</tr>
		<tr>
			<td>GET api/recipes/{recipeId}/reviews/{reviewId}</td>
			<td>Gets one review by review id and recipe id</td>
		</tr>
		<tr>
			<td>POST api/recipes/{recipeId}/reviews</td>
			<td>Creates a new review for a recipe by recipe by</td>
		</tr>
		<tr>
			<td>PUT api/recipes/{recipeId}/reviews/{reviewId}</td>
			<td>Replaces an existing review by review id and recipe id</td>
		</tr>
		<tr>
			<td>DELETE api/recipes/{recipeId}/reviews/{reviewId}</td>
			<td>Deletes an existing review by review id and recipe id</td>
		</tr>



	</tbody>
</table>


### Implementation
Description of overall project structure

ERDiagram.png

### Technologies & Methodologies Used
bullet list or table of technologies/libraries/frameworks used

bullet list or table of development techniques (pair programming, agile, git collaboration, etc.)


### Lessons Learned

### Stretch Goals
