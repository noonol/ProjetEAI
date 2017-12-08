/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module("app", [])
        .service('MonService', function () {

        })
// Constructeur pour les événements simplifiés

        .controller("MonCtrl", function ($scope, $http) {
            $scope.creerContrat = function () {
                var nomCoordonnees = $scope.nomCoordonnees;
                var nomManif = $scope.nomManif;
                var typeManif = "";
                if ($scope.familiale === true) {
                    typeManif = "familiale";
                } else if ($scope.associative === true) {
                    typeManif = "associative";
                } else if ($scope.professionnelle === true) {
                    typeManif = "professionnelle";
                }

                var nbParticipants = $scope.nbParticipants;
                var dateManif = $scope.dateManif;
                var debutManif = "";
                if ($scope.debut11 === true) {
                    debutManif = "11:00";
                } else if ($scope.debut18 === true) {
                    debutManif = "18:00";
                }

                var finManif = "";
                if ($scope.fin18 === true) {
                    finManif = "18:00";
                } else if ($scope.fin00 === true) {
                    finManif = "00:00";
                } else if ($scope.fin03 === true) {
                    finManif = "03:00";
                }

                var typePrestation = "";
                if ($scope.cocktailSeul === true) {
                    typePrestation = "cocktailSeul";
                } else if ($scope.lunch === true) {
                    typePrestation = "lunch";
                } else if ($scope.repasAssis === true) {
                    typePrestation = "repasAssis";
                }

                var boisson = "";
                if ($scope.cocktailMaison === true) {
                    boisson = "cocktailMaison";
                }

                var animations = "";
                if ($scope.disco === true) {
                    animations = "disco";
                } else if ($scope.discoAnimation === true) {
                    animations = "discoAnimation";
                } else if ($scope.orchestre === true) {
                    animations = "orchestre";
                } else if ($scope.groupeMusical === true) {
                    animations = "groupeMusical";
                }

                var prestaDeco = "";
                if ($scope.ornementationBasique === true) {
                    prestaDeco = "ornementationBasique";
                } else if ($scope.decoFlorale === true) {
                    prestaDeco = "decoFlorale";
                }

                var prestaCom = "";
                if ($scope.photos === true) {
                    prestaCom = "photos";
                } else if ($scope.videos === true) {
                    prestaCom = "videos";
                }

                var prestaSecu = "";
                if ($scope.accesSalle === true) {
                    prestaSecu = "accesSalle";
                } else if ($scope.parking === true) {
                    prestaSecu = "parking";
                }

                var data = {
                    nomCoordonnees: nomCoordonnees,
                    nomManif: nomManif,
                    typeManif: typeManif,
                    nbParticipants: nbParticipants,
                    dateManif: dateManif,
                    debutManif: debutManif,
                    finManif: finManif,
                    typePresta: typePrestation,
                    boisson: boisson,
                    animations: animations,
                    prestaDeco: prestaDeco,
                    prestaCom: prestaCom,
                    prestaSecu: prestaSecu
                }
                console.log(data);
                $http.post('/ProjetEAI-web/webresources/contrat', JSON.stringify(data)).then(function (response) {
                    if (response.data)
                        $scope.msg = "Post Data Submitted Successfully!";

                }, function (response) {
                    $scope.msg = "Service not Exists";
                });
            }


        });

