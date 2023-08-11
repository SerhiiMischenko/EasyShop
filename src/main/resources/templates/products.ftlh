<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Поиск товаров</h1>
    <hr>
    <form method="get" action="/">
        <div class="form-row">
            <div class="form-group">
                <label for="searchCity">Город</label>
                <select id="searchCity" required name="city" class="form-control">
                    <#include "cities.ftlh">
                </select>
            </div>
            <div class="form-group col-md-10">
                <label for="searchWord">Поиск по объявлениям</label>
                <input type="text" name="searchWord" <#if searchWord??>value="${searchWord}"</#if> class="form-control"
                       id="searchWord">
            </div>
            <button style="width: 100%" type="submit" class="btn btn-dark">Поиск</button>
        </div>
    </form>
    <hr>
    <div class="row">
        <#list products as product>
            <a href="/product/${product.id}" class="product-link col-md-4">
                <div class="product-card card text-white bg-dark my-3">
                    <div class="card-img-container">
                        <img src="/images/${product.previewImageId}" class="card-img-top">
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">${product.title}</h5>
                        <p class="card-text">${product.price} грн.</p>
                    </div>
                    <div class="card-footer">
                        ${product.city}
                    </div>
                </div>
            </a>
        </#list>
    </div>
</@t.template>