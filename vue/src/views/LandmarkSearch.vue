<template>
  <div class="input-wrapper">
    <input type="text" placeholder="Search Landmarks" v-model="zipFilter" />

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
* {
  font-size: 1.5rem;
}
.input-wrapper {
  display: block;
  align-items: center;
  justify-content: space-between;
  background: #e26d5c;
  padding: 0.5rem;
  border-radius: 00.5rem;
  color: white;
  box-shadow: 0.25rem 0.25rem 0rem #f0b2a8;
}
input {
  margin: 0 0.5rem 0 0.5rem;
  width: 100%;
  border: none;
  outline: none;
  background: #e26d5c;
  color: white;
}
::placeholder {
  color: #f0b2a8;
}
</style>