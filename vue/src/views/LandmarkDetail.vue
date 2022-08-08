<template>
  <div>
     <p>{{landmark.details}}</p>
     <p>{{landmark.address.street_number}} {{landmark.address.street_name}}</p>
     <p>{{landmark.address.zip_code}}</p>
  </div>
</template>

<script>
export default {
    name: "landmark-details",
  props: ["landmark"]

}
</script>

<style>

</style>