<template>
  <div>
    <div class="searchBox">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
                
            <input class="searchInput" type="text" name="" placeholder="Search" v-model="Filter">
            <button class="searchButton" href="#">
                
            </button>
        </div>
    <landmark-list v-bind:filteredLandmarks="filteredLandmarks"></landmark-list>
  </div>


</template>


<script>
import LandmarkList from "../components/LandmarkList.vue";

import LandmarkService from "../services/LandmarkService";
export default {
  components: {
    LandmarkList,
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
        return this.Filter == ""
          ? true
          : this.Filter == landmark.zip_code ||
              landmark.landmark_name
                .toLowerCase()
                .includes(this.Filter.toLowerCase());
      });
    },
  },
  created() {
    LandmarkService.search().then((response) => {
      this.landmarks = response.data;
    });
  },
};
</script>

<style scoped>
body {
    background-image: linear-gradient(to right , #cb2d3e , #ef473a);
}

.searchBox {
    position: absolute;
    top: 0%;
    left: 50%;
    transform:  translate(-50%,50%);
    background: white;
    height: 40px;
    border-radius: 40px;
    padding: 10px;

}

.searchBox:hover > .searchInput {
    width: 240px;
    padding: 0 6px;
}

.searchBox:hover > .searchButton {
  background: white;
  color : #2f3640;
}

.searchButton {
    color: white;
    float: right;
    width: 40px;
    height: 40px;
    border-radius: 50%;
    background: #2f3640;
    display: flex;
    justify-content: center;
    align-items: center;
    transition: 0.4s;
}

.searchInput {
    border:none;
    background: none;
    outline:none;
    float:left;
    padding: 0;
    color: rgb(0, 0, 0);
    font-size: 16px;
    transition: 0.4s;
    line-height: 40px;
    width: 0px;

}

@media screen and (max-width: 620px) {
.searchBox:hover > .searchInput {
    width: 150px;
    padding: 0 6px;
}}
</style>