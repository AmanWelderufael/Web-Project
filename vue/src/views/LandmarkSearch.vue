<template>
  <div id="body">
    
    <div class="search-box">
      <input class = "search-txt" type="text" name="zip" placeholder="Type to search" v-model="Filter">
      <a class="search-btn" href="#" for="zip"></a>
      <i class="fa-solid fa-magnifying-glass"></i>

    </div>
<landmark-list v-bind:filteredLandmarks="filteredLandmarks"></landmark-list>
    
   
  </div>
</template>


<script>
import LandmarkList from '../components/LandmarkList.vue'

import LandmarkService from '../services/LandmarkService'
export default {
  components:{
    LandmarkList
  },
  name: "Landmark-search",
  data() {
    return {
      Filter: "",
      landmarks: [],
    };
  },
  computed: {
    filteredLandmarks() {
   

      return this.landmarks.filter((landmark) => {
        return this.Filter == "" ? true: this.Filter == landmark.zip_code  || landmark.landmark_name.toLowerCase().includes(this.Filter.toLowerCase());
      });
    },

  },
  created() {

    LandmarkService.search().then( response => {
       this.landmarks = response.data;
    })

  },
};
</script>

<style scoped>
#body{
 min-height: 100vh;
 max-width: px;
 width: 100%;
 margin: 0 auto;
 background-color: red;
  
}

.search-box:hover > .search-txt {
  width: 240px;
  padding: 0 6px;
}
.search-box:hover > .search-btn {
  background: white;
}

.search-box{
position: relative;
height: 42px;
max-width: 400px;
background-color: green;
margin: 0 auto;

}

.search-btn{
  color: #e84118;
  float: right;
  widows: 40px;
  height: 40px;
  border-radius: 50%;
  background: #2f3640;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: 0.4s;
}

.search-txt{
  border: none;
  background: none;
  outline: none;
  float: left;
  padding: 0;
  color: white;
  font-size: 16px;
  transition: 0.4s;
  line-height: 40px;
  width: 0px;
}

</style>