<h1>Hi {{vm.user.firstname}}!</h1>
<p>You're logged in!!</p>
<h3>All registered users:</h3>
<ul>
    <li ng-repeat="user in vm.allUsers">
        {{user.username}} ({{user.firstname}} {{user.lastname}})
        - <a href="#" ng-click="vm.deleteUser(user.id)">Delete</a>
    </li>
</ul>
<p>&nbsp;</p>
<p><a href="#/login" class="btn btn-primary">Logout</a></p>