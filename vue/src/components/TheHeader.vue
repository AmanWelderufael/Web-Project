<template>
  <div class="header">

    
    
     <router-link class="logo"
            v-bind:to="{ name: 'home' }"
          
            >LOGO</router-link
          >
          
<!-- Add the logo as an image above --> 


    <nav>
      <ul class="nav_links">
        <li><a href="#">About</a></li>
        <li>
          <a href="#"
            ><router-link v-bind:to="{ name: 'Landmark-search' }"
              >Search</router-link
            ></a
          >
        </li>

        <!-- <li>
          <a href="#"
            ><router-link v-bind:to="{ name: 'Landmark-search' }"
              >Search</router-link
            ></a
          > -->
        <!-- </li> -->
        <li><a href="#">contact</a></li>
        <li class="login">
          <router-link
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token == ''"
            >Login</router-link
          >
          <router-link
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          >
        </li>
        <li>
          <router-link
            v-bind:to="{ name: 'home' }"
            v-if="$store.state.token == ''"
            >Home</router-link
          >
          <router-link
            v-bind:to="{ name: 'home' }"
            v-if="$store.state.token != ''"
            >Home</router-link
          >
        </li>
        <div class="welcome">
        <li>
          <p v-if="$store.state.token != ''"> welcome </p>  
          <h3>{{ $store.state.user.username }}</h3>
         
        </li>

       
        </div>
      </ul>
    </nav>

    <div>
      <!-- <p v-if="$store.state.token != ''">
        Welcome {{ $store.state.user.username }}
      </p> -->
    </div>
  </div>
</template>

<script>
export default {
  name: "the-header",
  data() {
    return {};
  },
};
</script>

<style scoped>
.logo {
  cursor: pointer;
  widows: 20px;
  margin-right: auto;
}

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  background-color: #112740;
}

li,
a,
button {
  font-family: sans-serif;
  font-weight: 500;
  font-size: 16px;
  color: #edf0f1;
  text-decoration: none;
}

.header {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  padding: 30px 10%;
}
.nav_links {
  list-style: none;
}
.nav_links li {
  display: inline-block;
  padding: 0px 20px;
}
.nav_links li a {
  transition: all 0.3s ease 0s;
}
.nav_links li a:hover {
  color: #0088a9;
}
.welcome {

  padding: 1px;
}

</style>
