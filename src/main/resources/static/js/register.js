$(document).ready(function() {
    $('#contact_form').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            soloOrPartner: {
                validators: {
                    notEmpty: {
                        message: 'Va rugam alegeti Da sau Nu'
                    }
                }
            },
            partnerName: {
                validators: {
                    stringLength: {
                        min: 2
                    },
                    notEmpty: {
                        message: 'Va rugam introduceti numele partenerului dvs.'
                    }
                }
            },
            firstName: {
                validators: {
                    stringLength: {
                        min: 2
                    },
                    notEmpty: {
                        message: 'Va rugam introduceti numele dumneavoastra'
                    }
                }
            },
            lastName: {
                validators: {
                    stringLength: {
                        min: 2
                    },
                    notEmpty: {
                        message: 'Va rugam introduceti prenumele dumneavoastra'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Introduceti o adresa de email valida'
                    },
                    emailAddress: {
                        message: 'Adresa de email nu este valida'
                    }
                }
            },
            phoneNumber: {
                validators: {
                    stringLength: {
                        min: 10,
                        message: 'Va rugam introduceti un numar de telefon valid'
                    },
                    digits: {
                        message: 'Va rugam introduceti un numar de telefon format doar din cifre'
                    },
                    notEmpty: {
                        message: 'Va rugam completati numarul dvs. de telefon'
                    }
                }
            },
            type: {
                validators: {
                    notEmpty: {
                        message: 'Va rugam alegeti o optiune'
                    }
                }
            }
        }
    })
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
            $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');
        });
});

