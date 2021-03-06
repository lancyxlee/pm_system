var menutab = {};
var mainActiveId = 'home';
var menus = [];
var menuParent = {};
var bigDataMenus = null;
var menuUserName = "";


/**
 * 加载左侧菜单1
 */
function loadMenu() {
    var administrator = '[{"id": "1","name": "工资核算绩效管理系统","icon": null,"url": "","parentId": "",'
        + '"childs": [{"id": "11","name": "用户管理","icon": "","url": "user/user.html","parentId": "1",'
        + '"childs": [{"id": "111","name": "个人信息管理","icon": "","url": "user/user.html","parentId": "11",'
        + '"childs": []},{"id": "112","name": "修改密码","icon": "","url": "user/showAddUser.html","parentId": "11",'
        + '"childs": []}]},{"id": "12","name": "人事管理","icon": "","url": "dept/dept.html","parentId": "1",'
        + '"childs": [{"id": "121","name": "员工信息管理","icon": "","url": "dept/dept.html","parentId": "12",'
        + '"childs": []},{"id": "122","name": "部门信息管理","icon": "","url": "dept/showAddDept.html","parentId": "12",'
        + '"childs": []}]},{"id": "14","name": "薪资管理","icon": "","url": "job/job.html","parentId": "1",'
        + '"childs": [{"id": "141","name": "部门工资信息","icon": "","url": "job/showAddJob.html","parentId": "14",'
        + '"childs": []},{"id": "142","name": "员工工资信息","icon": "","url": "job/job.html","parentId": "14",'
        + '"childs": []}]},{"id": "15","name": "考勤管理","icon": "","url": "employee/employee.html","parentId": "1",'
        + '"childs": [{"id": "151","name": "考勤信息","icon": "","url": "employee/employee.html","parentId": "15",'
        + '"childs": []},{"id": "152","name": "考勤奖罚设置","icon": "","url": "employee/showAddEmployee.html","parentId": "15",'
        + '"childs": []}]},{"id": "16","name": "绩效管理","icon": "","url": "notice/notice.html","parentId": "1",'
        + '"childs": [{"id": "161","name": "工作计划","icon": "","url": "notice/notice.html","parentId": "16",'
        + '"childs": []},{"id": "162","name": "绩效核算","icon": "","url": "notice/showAddNotice.html","parentId": "16",'
        + '"childs": []},{"id": "163","name": "绩效奖罚设置","icon": "","url": "notice/previewNotice.html","parentId": "16",'
        + '"childs": []}]},{"id": "17","name": "任务管理","icon": "","url": "document/document.html","parentId": "1",'
        + '"childs": [{"id": "171","name": "任务信息","icon": "","url": "document/document.html","parentId": "17","childs": []}]}]}]';

    var manager = '[{"id": "1","name": "工资核算绩效管理系统","icon": null,"url": "","parentId": "",'
        + '"childs": [{"id": "11","name": "用户管理","icon": "","url": "user/user.html","parentId": "1",'
        + '"childs": [{"id": "111","name": "个人信息管理","icon": "","url": "user/user.html","parentId": "11",'
        + '"childs": []},{"id": "112","name": "修改密码","icon": "","url": "user/showAddUser.html","parentId": "11",'
        + '"childs": []}]},{"id": "12","name": "人事管理","icon": "","url": "dept/dept.html","parentId": "1",'
        + '"childs": [{"id": "121","name": "员工信息管理","icon": "","url": "dept/dept.html","parentId": "12",'
        + '"childs": []}]},{"id": "14","name": "薪资管理","icon": "","url": "job/job.html","parentId": "1",'
        + '"childs": [{"id": "142","name": "员工工资信息","icon": "","url": "job/job.html","parentId": "14",'
        + '"childs": []}]},{"id": "15","name": "考勤管理","icon": "","url": "employee/employee.html","parentId": "1",'
        + '"childs": [{"id": "151","name": "考勤信息","icon": "","url": "employee/employee.html","parentId": "15",'
        + '"childs": []}]},{"id": "16","name": "绩效管理","icon": "","url": "notice/notice.html","parentId": "1",'
        + '"childs": [{"id": "161","name": "工作计划","icon": "","url": "notice/notice.html","parentId": "16",'
        + '"childs": []},{"id": "162","name": "绩效核算","icon": "","url": "notice/showAddNotice.html","parentId": "16",'
        + '"childs": []}]},{"id": "17","name": "任务管理","icon": "","url": "document/document.html","parentId": "1",'
        + '"childs": [{"id": "171","name": "任务信息","icon": "","url": "document/document.html","parentId": "17","childs": []}]}]}]';

    var ordinary = '[{"id": "1","name": "工资核算绩效管理系统","icon": null,"url": "","parentId": "",'
        + '"childs": [{"id": "11","name": "用户管理","icon": "","url": "user/user.html","parentId": "1",'
        + '"childs": [{"id": "111","name": "个人信息管理","icon": "","url": "user/user.html","parentId": "11",'
        + '"childs": []},{"id": "112","name": "修改密码","icon": "","url": "user/showAddUser.html","parentId": "11",'
        + '"childs": []}]},{"id": "14","name": "薪资管理","icon": "","url": "job/job.html","parentId": "1",'
        + '"childs": [{"id": "142","name": "员工工资信息","icon": "","url": "job/job.html","parentId": "14",'
        + '"childs": []}]},{"id": "15","name": "考勤管理","icon": "","url": "employee/employee.html","parentId": "1",'
        + '"childs": [{"id": "151","name": "考勤信息","icon": "","url": "employee/employee.html","parentId": "15",'
        + '"childs": []}]},{"id": "16","name": "绩效管理","icon": "","url": "notice/notice.html","parentId": "1",'
        + '"childs": [{"id": "161","name": "工作计划","icon": "","url": "notice/notice.html","parentId": "16",'
        + '"childs": []},{"id": "162","name": "绩效核算","icon": "","url": "notice/showAddNotice.html","parentId": "16",'
        + '"childs": []}]},{"id": "17","name": "任务管理","icon": "","url": "document/document.html","parentId": "1",'
        + '"childs": [{"id": "171","name": "任务信息","icon": "","url": "document/document.html","parentId": "17","childs": []}]}]}]';


    var permission = 2;

    $.ajax({
        url:"getPermission",
        type: "get",
        async: false,//使用同步的方式,true为异步方式
        error: function (res) {
            console.log(res);
            $.ligerDialog.error("权限认证有误");
        },
        success: function(res){
            console.log(res);
            permission = eval(res);
        }
    });

    if (permission === 0) {
        var jsonObj = $.parseJSON(administrator);
    } else if (permission === 1){
        var jsonObj = $.parseJSON(manager);
    } else {
        var jsonObj = $.parseJSON(ordinary);
    }

    var msg = [];
    for (var i = 0; i < jsonObj.length; i++) {
        msg[i] = jsonObj[i];
    }
    bigDataMenus = msg;
    showNav(msg);
    //默认显示第一个一级导航菜单的二级菜单。
    showSideBarByNav(bigDataMenus[0].id);
}

/**
 * 根据导航菜单id显示左侧二级菜单
 * @param {Object} navId
 */
function showSideBarByNav(navId) {
    $("#leftMenuNav").html("");
    for (var i = 0; i < bigDataMenus.length; i++) {
        if (navId == bigDataMenus[i].id) {
            menus = bigDataMenus[i].childs;
            var ul = $("#leftMenuNav")[0];
            for (var i = 0; i < menus.length; i++) {
                var m = menus[i];
                var menuId = "m-" + m.id;
                var tab = createOneMenu(m, menuId, m.childs != null && m.childs.length > 0);
                menuParent[m.id] = '';
                addChildMenu(m, tab)
                $(ul).append(tab);
            }
            return;
        }
    }
}

function firstMenuClick() {
    var a = findFirstMenu($("#leftMenuNav"));
    if (a.length > 0) {
        a[0].click();
    }
}

/**
 * 显示导航(一级)菜单
 */
function showNav(menus) {
    for (var i = 0; i < menus.length; i++) {
        var li = $('<li>' +
            '<a class="sysMenuItem" id="' + menus[i].id + '">' + menus[i].name + '</a>' +
            '</li>');
        li.find("a").click(function () {
            var navId = $(this).attr("id");
            showSideBarByNav(navId);
            firstMenuClick();
        });
        $('.sysMenu ul').append(li);
    }
}

//获取第一个可以点击的左侧菜单。
function findFirstMenu(ul) {
    if (ul.find('li>a[data-url]').length > 0) {
        return $(ul.find('li>a[data-url]').children(0));
    } else {
        return null;
    }

    if (ul.find('li').length > 0) {
        var firstLi = $(ul.find('li')[0]);
        if (firstLi.find('ul').length > 0) {//包含多个孩子
            return findFirstMenu($(firstLi.find('ul')[0]))
        } else {
            return firstLi.find('a');
        }
    } else {
        return null;
    }
}

/**
 * 增加子菜单
 * @param parentMenu
 * @param parentEl
 */
function addChildMenu(parentMenu, parentEl) {
    var childs = parentMenu.childs;
    if (childs != null) {
        var id = "m-" + parentMenu.id + '-ul'
        var ul = $("<ul>", {
            "id": id,
            "class": "nav sidebar-subnav  collapse"
        });
        $("<li>", {
            "class": "sidebar-subnav-header",
            "html": parentMenu.name
        }).appendTo(ul);
        for (var i = 0; i < childs.length; i++) {
            var m = childs[i];
            var menuId = "m-" + m.id;
            menuParent[m.id] = parentMenu.id;
            var tab = createOneMenu(m, menuId, false);
            tab.appendTo(ul);
            $(parentEl).append(ul);
        }
    }
}

var begin = true;

/**
 * 渲染一个菜单
 * @param m
 * @param menuId
 * @param hasChild
 * @returns
 */
function createOneMenu(m, menuId, hasChild) {
    var tab = null;
    var a;

    if (hasChild) {

        tab = $("<li>", {"id": menuId, "data-title": m.name})
        a = $("<a>", {
            "data-toggle": "collapse",
            "href": "javascript:void(0);",
            "data-target": "#" + menuId + "-ul",
            "class": "menu-item collapsed"
        }).bind('click', function (event) {
            $sidebar = $('.sidebar');
            var sidebarCollapse = $sidebar.find('.collapse');
            sidebarCollapse.filter('.in').removeClass("open");
            $sidebar.find("i").removeClass("open");
            sidebarCollapse.filter('.in').collapse('hide');
            var tarId = $(this).data("target");
            var tarEl = $(tarId)[0];
            var aEl = $(this)[0];


            if ($(tarEl).hasClass("collapse")) {
                $(aEl).find("i").addClass("open");
                $(tarEl).collapse('show');

            } else {
                $(aEl).find("i").removeClass("open");
                $(tarEl).collapse('hide');

            }


            event.stopPropagation();
        });
    } else {

        tab = $("<li>", {"id": menuId, "class": "menu-item", "data-title": m.name})
        a = $("<a>", {
            "href": "javascript:void(0);",
            "data-id": m.id,
            "data-title": m.name,
            "data-url": m.url,
            "data-menuid": menuId
        }).bind("click", function () {

            menuItemClick.call(this);
        });
    }
    $("<em>", {
        "class": "menu-icon",
        "style": (m.icon == null || m.icon == '') ? '' : "background-image:url('../hrm/images" + m.icon + "')"
    }).appendTo(a);

    //先创建i标签，再创建span标签，解决火狐出现，小三角视觉上跑出a标签的bug 2018-03-20 - xugy
    if (hasChild) {
        $("<i>", {
            "class": "fa fa-angle-right"
        }).appendTo(a);
    }

    $("<span>", {
        "text": m.name
    }).appendTo(a);


    tab.append(a);
    return tab;
}

/**
 * 菜单点击功能
 */
function menuItemClick() {
    var id = $(this).data("id");
    var title = $(this).data("title");
    var url = $(this).data("url");
    var menuid = $(this).data("menuid");

    selectMenu(menuid);
    console.log(id , "++", title, "++", url, "++", menuid);
    tabAdd(id, title, url, menuid);
}

/**
 * 选中菜单
 * @param menuid
 */
function selectMenu(menuid) {

    var menuObj = $("#" + menuid);

    if (menuObj.length == 0) {
        return;
    }

    if (mainActiveId != null && mainActiveId != "" && menuid != null && menuid != "") {
        $("#" + mainActiveId).removeClass("active");
        mainActiveId = menuid;
    }
    $("#" + menuid).addClass("active");
}

/**
 * 增加一个Tab页
 * @param id
 * @param title
 * @param url
 * @param activeId
 * @param parentActiveId
 */
function tabAdd(id, title, url, icon, closable) {


    menutab.removeAll();

    icon = (icon == undefined) ? "" : icon;
    closable = (closable == undefined) ? true : false;
    menutab.appendTab({id: id, title: title, url: url, icon: icon, closable: closable});
}


(function (window, document, $, undefined) {
    var $win;
    var $html;
    var $body;
    var $sidebar;
    var mq;

    $(function () {

        $win = $(window);
        $html = $('html');
        $body = $('body');
        $sidebar = $('.sidebar');
        mq = APP_MEDIAQUERY;

        // SIDEBAR ACTIVE STATE
        // -----------------------------------

        // Find current active item
        var currentItem = $('.sidebar .active').parents('li');

        // hover mode don't try to expand active collapse
        if (!useAsideHover())
            currentItem
                .addClass('active')     // activate the parent
                .children('.collapse')  // find the collapse
                .collapse('show');      // and show it

        // remove this if you use only collapsible sidebar items
        $sidebar.find('li > a + ul').on('show.bs.collapse', function (e) {
            if (useAsideHover()) e.preventDefault();
        });

        // SIDEBAR COLLAPSED ITEM HANDLER
        // -----------------------------------


        var eventName = isTouch() ? 'click' : 'mouseenter';
        var subNav = $();
        $sidebar.on(eventName, '.nav > li', function () {
            if (isSidebarCollapsed() || useAsideHover()) {

                subNav.trigger('mouseleave');
                subNav = toggleMenuItem($(this));
                // Used to detect click and touch events outside the sidebar
                sidebarAddBackdrop();
            }

        });

        var sidebarAnyclickClose = $sidebar.data('sidebarAnyclickClose');

        // Allows to close
        if (typeof sidebarAnyclickClose !== 'undefined') {

            $('.wrapper').on('click.sidebar', function (e) {
                // don't check if sidebar not visible
                if (!$body.hasClass('aside-toggled')) return;

                var $target = $(e.target);
                if (!$target.parents('.aside').length && // if not child of sidebar
                    !$target.is('#user-block-toggle') && // user block toggle anchor
                    !$target.parent().is('#user-block-toggle') // user block toggle icon
                ) {
                    $body.removeClass('aside-toggled');
                }

            });
        }

    });

    function sidebarAddBackdrop() {

        var $backdrop = $('<div/>', {'class': 'dropdown-backdrop'});
        console.log($backdrop);
        $backdrop.insertAfter('.aside').on("click mouseenter", function () {

            removeFloatingNav();
        });
        $(".nav-floating").find("a").bind("click", function () {
            menuItemClick.call(this);
        })
    }

    // Open the collapse sidebar submenu items when on touch devices
    // - desktop only opens on hover
    function toggleTouchItem($element) {
        $element
            .siblings('li')
            .removeClass('open')
            .end()
            .toggleClass('open');
    }

    // Handles hover to open items under collapsed menu
    // -----------------------------------
    function toggleMenuItem($listItem) {

        removeFloatingNav();

        var ul = $listItem.children('ul');

        if (!ul.length) {
            var title = $($listItem).data('title');
            var layerIndex = layui.layer.tips(title, '#' + $($listItem).attr('id'));
            $($listItem).on('mouseleave', function (env) {
                var temp = this;
                var parent = $(temp).parent();
                layui.layer.close(layerIndex);
                $(this).unbind('mouseleave');
            });
            return $();
        }
        if ($listItem.hasClass('open')) {
            toggleTouchItem($listItem);
            return $();
        }

        var $aside = $('.aside');
        var $asideInner = $('.aside-inner'); // for top offset calculation
        // float aside uses extra padding on aside
        var mar = parseInt($asideInner.css('padding-top'), 0) + parseInt($aside.css('padding-top'), 0);

        var subNav = ul.clone().appendTo($aside);

        toggleTouchItem($listItem);

        var itemTop = ($listItem.position().top + mar) - $sidebar.scrollTop();
        var vwHeight = $win.height();

        subNav
            .addClass('nav-floating')
            .css({
                position: 'absolute',//解决ie下，左侧菜单收起时，悬浮显示二级菜单被遮盖
                top: itemTop,
                bottom: (subNav.outerHeight(true) + itemTop > vwHeight) ? 0 : 'auto'


            });

        subNav.on('mouseleave', function () {
            toggleTouchItem($listItem);
            subNav.remove();
        });

        return subNav;
    }

    function removeFloatingNav() {
        $('.sidebar-subnav.nav-floating').remove();
        $('.dropdown-backdrop').remove();
        $('.sidebar li.open').removeClass('open');
    }

    function isTouch() {
        return $html.hasClass('touch');
    }

    function isSidebarCollapsed() {
        return $body.hasClass('aside-collapsed');
    }

    function isSidebarToggled() {
        return $body.hasClass('aside-toggled');
    }

    function isMobile() {
        return $win.width() < mq.tablet;
    }

    function isFixed() {
        return $body.hasClass('layout-fixed');
    }

    function useAsideHover() {
        return $body.hasClass('aside-hover');
    }

})(window, document, window.jQuery);
// TOGGLE STATE
// -----------------------------------

(function (window, document, $, undefined) {

    $(function () {

        var $body = $('body');
        toggle = new StateToggler();
        $('[data-toggle-state]')
            .on('click', function (e) {

                // e.preventDefault();
                e.stopPropagation();
                var element = $(this),
                    classname = element.data('toggleState'),
                    target = element.data('target'),
                    noPersist = (element.attr('data-no-persist') !== undefined);

                // Specify a target selector to toggle classname
                // use body by default
                var $target = target ? $(target) : $body;
                if (classname) {
                    if ($target.hasClass(classname)) {
                        $target.removeClass(classname);
                        if (!noPersist)
                            toggle.removeState(classname);
                    } else {
                        $target.addClass(classname);
                        if (!noPersist)
                            toggle.addState(classname);
                    }

                }
                // some elements may need this when toggled class change the content size
                // e.g. sidebar collapsed mode and jqGrid
                window.setTimeout(function () {
                    $(window).resize();
                }, 500);


            });
    });

    // Handle states to/from localstorage
    window.StateToggler = function () {

        var storageKeyName = 'jq-toggleState';

        // Helper object to check for words in a phrase //
        var WordChecker = {
            hasWord: function (phrase, word) {
                return new RegExp('(^|\\s)' + word + '(\\s|$)').test(phrase);
            },
            addWord: function (phrase, word) {
                if (!this.hasWord(phrase, word)) {
                    return (phrase + (phrase ? ' ' : '') + word);
                }
            },
            removeWord: function (phrase, word) {
                if (this.hasWord(phrase, word)) {
                    return phrase.replace(new RegExp('(^|\\s)*' + word + '(\\s|$)*', 'g'), '');
                }
            }
        };

        // Return service public methods
        return {
            // Add a state to the browser storage to be restored later
            addState: function (classname) {
                var data = $.localStorage.get(storageKeyName);

                if (!data) {
                    data = classname;
                } else {
                    data = WordChecker.addWord(data, classname);
                }

                $.localStorage.set(storageKeyName, data);
            },

            // Remove a state from the browser storage
            removeState: function (classname) {
                var data = $.localStorage.get(storageKeyName);
                // nothing to remove
                if (!data) return;

                data = WordChecker.removeWord(data, classname);

                $.localStorage.set(storageKeyName, data);
            },

            // Load the state string and restore the classlist
            restoreState: function ($elem) {
                var data = $.localStorage.get(storageKeyName);
                window.setTimeout(function () {
                    $(window).resize();
                }, 500);
                // nothing to restore
                if (!data) return;
                $elem.addClass(data);
            }

        };
    };
    /**/
})(window, document, window.jQuery);

function getRequest() {
    console.log("dailiwen1");
    var url = decodeURI(location.search); //获取url中"?"符后的字串
    console.log(url);
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            console.log(strs[i]);
            var index = strs[i].indexOf('=');
            if (index != -1) {
                var key = strs[i].substring(0, index);
                var val = unescape(strs[i].substring(index + 1));
                theRequest[key] = val;
            }
        }
    }
    return theRequest;
}

/**
 * 打开一个通过URL传来的菜单
 */
function _addDefultTab() {
    var params = getRequest();
    var id = params['_redict_menu_id'];
    var name = params['_redict_menu_name'];
    var params = params['_redict_menu_param'];
    console.log(id + "++" + name + "++" + params);
    if (id == undefined || name == undefined) {
        var m = menus[0];
        var menuId = "m-" + m.id;
        if (m.childs != null && m.childs.length > 0) {
            $($('#' + menuId).find('a')[0]).click();
            var child = m.childs[0];
            var childId = 'm-' + child.id;
            var childName = child.name;
            var childUrl = child.url;
//			tabAdd(childId,childName,childUrl);
//			selectMenu(childId);
            $($('#' + menuId).find('a')[1]).click();
        } else {
            var name = m.name;
            var url = m.url;
            $('#' + menuId).find('a').click();
        }
        return;
    } else {
        var url = location.href;
        if (url.indexOf("?") != -1) {
            url = url.substring(0, url.indexOf('?'));
        }
        if (params != undefined) {
            params = params.replace(';', '&')
            url += '?' + params;
        }
        tabAdd(id, name, url);
        if (menuParent[id] != undefined && menuParent[id] != '') {
            $($('#m-' + menuParent[id]).find('a')[0]).click();
        }
        selectMenu("m-" + id);
    }
}

function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

function loginOut() {
    //window.location.replace("loginForm.html");

    $.ajax({
        type: "POST",
        url: "loginOut",
        error: function (res) {
           alert("出错了，请与管理员联系");
        },
        success: function (res) {
            window.location.replace("loginForm.html");
        }
    });

}

$(function () {
    var $body = $('body');
    new StateToggler().restoreState($body);
    loadMenu();
    layui.use(["jqtab"], function () {
        var funTab = $("#funTab");
        menutab = funTab.btab();
        menutab.resizeTab();
        setTimeout(_addDefultTab, 200);
    });
    //var menuUserName=GetQueryString("menuUserName");
    //$("#userNameSpan").html(menuUserName);
})
