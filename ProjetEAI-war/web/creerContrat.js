/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module("app", [])
        .service('MonService', function () {

        })
// Constructeur pour les événements simplifiés

        .controller("MonCtrl", function($scope) {
                $scope.creerContrat = function(){
                    var nomCoordonnees = $scope.nomCoordonnees;
                    var nomManif = $scope.nomManif;
                    var typeManif ="";
                    if( $scope.familiale === true){
                      typeManif = "familiale";
                    }else if ($scope.associative === true){
                         typeManif = "associative";
                    }else if ($scope.professionnelle === true){
                        typeManif = "professionnelle";
                    }
                    
                    var data = {
                        nomCoordonnees : nomCoordonnees,
                        
                    }
                    console.log(nomCoordonnees);
                }
                });

